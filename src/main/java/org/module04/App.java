package org.module04;

import org.module04.human.HumanService;
import org.module04.human.HumanService2;
import org.module04.storage.DatabaseInitService;
import org.module04.storage.Storage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws SQLException {
        Storage storage = Storage.getInstance();

        new DatabaseInitService().initDb(storage);

        HumanService2 humanService2 = new HumanService2(storage);
//        boolean result = humanService2.createNewHuman(
//                "Jhon Wick",
//                LocalDate.now().minusYears(40)
//        );
//        System.out.println("result = " + result);


        humanService2.printHumanInfo(3);


//
//        HumanService humanService = new HumanService(storage);
//
//        humanService.printHumanInfo(2);

//        humanService.createNewHuman("Mark Zuckerberg", LocalDate.now().minusMonths(1));
//        humanService.printHumanIds();

        // Insert into human
//        String insertSql = String.format(
//                "INSERT INTO human (name, birthday) VALUES('%s', '%s')",
//                "Elon Musk",
//                LocalDate.now()
//        );
//        storage.executeUpdate(insertSql);

        // Select from human
//        String selectSql = "SELECT id, name, birthday FROM human WHERE id = 1";
//
//        try (Statement st = storage.getConnection().createStatement()) {
//            try (ResultSet rs = st.executeQuery(selectSql)) {
//                if (rs.next()) {
//                    long id = rs.getLong("id");
//                    String name = rs.getString("name");
//                    LocalDate birthday = LocalDate.parse(rs.getString("birthday"));
//
//                    System.out.println("Person: id = " + id + ", name = " + name + ", birthday = " + birthday);
//                } else {
//                    System.out.println("Human with this id not found");
//                }
//            }
//        }

    }
}