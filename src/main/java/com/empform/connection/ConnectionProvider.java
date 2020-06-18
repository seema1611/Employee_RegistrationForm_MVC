package com.empform.connection;


import com.empform.interfaces.Provider;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider implements Provider {
    static Connection con = null;

    public static Connection getCon() {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(CONURL, USERNAME, PASSWORD);
            System.out.println(con);

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}

