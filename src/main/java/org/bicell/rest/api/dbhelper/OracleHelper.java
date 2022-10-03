package org.bicell.rest.api.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class OracleHelper {

    private final String username="";

    private final String password="";

    private final String db_url="";


    public OracleHelper() {
        TimeZone timeZone=TimeZone.getTimeZone("Asia/Kolkata");
        TimeZone.setDefault(timeZone);
    }

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(db_url, username, password);
    }
}
