package org.farrukh.examples.java.jdbc.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Farrukhjon on 25-Sep-15.
 */
public class BaseMySQLConnection {

    private static final String MYSQL_PROPERTIES = "src/main/resources/mysql.properties";

    public final Properties load() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(MYSQL_PROPERTIES));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
