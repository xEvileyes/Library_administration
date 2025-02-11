package com.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    private static final String URL = "jdbx:sqlite:library.db";

    public static Connection connect(){ // Verbindung zur Datenbank
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Verbindung zum Server hergestellt");
            }
        catch(SQLException e) {
            System.err.println("Verbindung fehgeschlagen: " + e.getMessage());
        }
        return conn;
    }


public static void createTable(){
    String sql = "CREATE TABLE IF NOT EXISTS books ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT NOT NULL, " +
                "author TEXT NOT NULL, " +
                "pages INTEGER NOT NULL" +
                ");";
    try (Connection conn = connect();
        Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out,println("Tabelle books wurde erstellt");
        }
    catch (SQLException e) {
        System.err.println("Fehler beim erstellen der Tabelle "+ e.getMessage());
    }
}

}
