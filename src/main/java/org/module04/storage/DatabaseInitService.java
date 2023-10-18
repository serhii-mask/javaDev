package org.module04.storage;

import org.module04.prefs.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseInitService {
    public void initDb(Storage storage) {
        try {
            String initDbFilename = new Prefs().getString(Prefs.INIT_DB_SQL_FILE_PATH);

            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(initDbFilename))
            );

           storage.executeUpdate(sql);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
