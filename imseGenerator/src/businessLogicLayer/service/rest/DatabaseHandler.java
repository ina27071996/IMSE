package businessLogicLayer.service.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//The DatabaseHandler class handles the connection with the database.
public class DatabaseHandler {

    private static final Connection connection = null;

    /**
     * The getConnection method is used for making a connection to the database. Upon making the connection, it checks for the connection to be null in order to avoid creating multiple connections to the database which can lead to problems.
     * @param username String which contains the username
     * @param password String which contains the password
     * @return if the connection is successful, the desired connection is returned
     * @throws SQLException
     */
    public static Connection getConnection(String username, String password) throws SQLException {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
            } catch (ClassNotFoundException e) {
                System.out.println("Error: " + e.toString());
                e.printStackTrace();
            }
        }
        return DriverManager.getConnection("jdbc:mysql://"+"sql11.freemysqlhosting.net"+":"+"3306"+"/sql11217795",username, password);
    }

    /**
     * The closeConnection method is used to close the connection with the database.
     */
    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
