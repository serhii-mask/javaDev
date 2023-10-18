package org.module04.human;

import org.module04.storage.Storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class HumanService2 {
    private PreparedStatement insertSt;
    private PreparedStatement selectByIdSt;
    public HumanService2(Storage storage) {
        Connection connection = storage.getConnection();

        try {
            insertSt = connection.prepareStatement(
                    "INSERT INTO human (name, birthday) VALUES(?, ?)"
            );
            selectByIdSt = connection.prepareStatement(
                    "SELECT name, birthday FROM human WHERE id = ?"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public boolean createNewHuman(String name, LocalDate birthday) {

        try {
            insertSt.setString(1, name);
            insertSt.setString(2, birthday.toString());
            return insertSt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean printHumanInfo(long id) {
        try {
            selectByIdSt.setLong(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        try (ResultSet resultSet = selectByIdSt.executeQuery()) {
            if (!resultSet.next()) {
                System.out.println("Human with id " + id + " not found!");
                return false;
            }

            String name = resultSet.getString("name");
            String birthday = resultSet.getString("birthday");
            System.out.println("name: " + name + ", birthday: " + birthday);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
