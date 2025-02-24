package com.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseManager {

    private static final String URL = "jdbc:sqlite:library.db";

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
                System.out.println("Tabelle books wurde erstellt");
        }
        catch (SQLException e) {
            System.err.println("Fehler beim erstellen der Tabelle "+ e.getMessage());
        }
    }

    public static void insertBook(Book book) {
        String sql = "INSERT INTO books (title, author, pages) VALUES (?,?,?)";
        try (Connection conn = connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getPages());
            System.out.println("Das Buch "+book.getTitle()+" wurde der Biblothek hinzugefügt.");
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.err.println("Fehler beim Einfügen des Buches: "+ e.getMessage());
        }
    }

    public static ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT title, author, pages FROM books";
        try (Connection conn = connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book(
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getInt("pages")
                );
                books.add(book);
            }
        }
        catch (SQLException e) {
            System.err.println("Fehler beim Abruf der Bucher: "+e.getMessage());
        }
        return books;
    }

    public static ArrayList<Book> deleteBook(String title) { // Löschung von Bücher
        ArrayList<Book> books = new ArrayList<>();
        String sql = "DELETE FROM books WHERE title = ?";
        try (Connection conn = connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,title);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 1) { // Abfrage ob mehrer Bücher gelöscht wurden
                System.out.println("Das Buch mit dem Title "+title+" wurde gelöscht. Es wurden "+affectedRows+" Bücher gelöscht.");
            }
            else {
                System.out.println("Das Buch mit dem Title "+title+" wurde gelöscht. Es wurde "+affectedRows+" Buch gelöscht.");
            }            
        }
        catch (SQLException e) {
            System.err.println("Fehler beim löschen des Buches "+ e.getMessage());
        }
        return books;
    }

    public static ArrayList<Book> findBookByTitle(String title) {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT title, author, pages FROM books WHERE title = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Book book = new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("pages")
                );
                books.add(book);
            }
        } catch (SQLException e) {
            System.err.println("Fehler beim Suchen des Buches: " + e.getMessage());
        }
        return books;
    }

    public static ArrayList<Book> findBookByAuthor(String author) {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT title, author, pages FROM books WHERE author = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, author);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Book book = new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("pages")
                );
                books.add(book);
            }
        } catch (SQLException e) {
            System.err.println("Fehler beim Suchen des Autors: " + e.getMessage());
        }
        return books;
    }
}
