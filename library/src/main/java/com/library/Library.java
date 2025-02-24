package com.library;
import java.util.ArrayList;

public class Library {
    
	static {
        DatabaseManager.createTable();
    }
		
	public Library() {		// erstellt eine Bücherei
	}
	
	public void displayDetailBook() { // gibt alle Infos zu allen Büchern aus
		ArrayList<Book> books = DatabaseManager.getAllBooks();
		for (Book book: books) {
			book.displayDetails();			
		}
	}
	
	public void addBook(Book book) { // fügt ein Buch der Datenbank hinzu
		DatabaseManager.insertBook(book);
	}
	
	public void findBookByTitle(String title) {
		ArrayList<Book> books = DatabaseManager.findBookByTitle(title);
		boolean noTitle = true;
		for (Book book: books) {
			if(book.getTitle().equals(title)) {
				System.out.println("Das Buch "+title+" ist in der Biblothek vorhanden.");
				noTitle = false;
			}
		}
		if(noTitle == true) {
			System.out.println("Tut uns leid, wir haben leider kein Buch mit dem Titel "+title+" da.");
		}
	}

	public void deleteBook(String title) {
		ArrayList<Book> books = DatabaseManager.deleteBook(title);
		for (Book book: books) {
			if(book.getTitle().equals(title)){
				title = null;
				System.out.println("Das Buch mit dem Title "+title+" wurde gelöscht.");
			}
		}
	}
	
	public void findBookByAuthor(String author) {
		boolean noAuthor = true;
		ArrayList<Book> books = DatabaseManager.findBookByAuthor(author);
		for (Book book: books) {
			if(book.getAuthor().equals(author)) {
				System.out.println("Der Author "+author+" ist in der Biblothek vorhanden mit dem Buch " + book.getTitle() +".");
				noAuthor = false;
			}
		}
		if(noAuthor == true) {
			System.out.println("Leider ist der Author "+author+" nicht in unserer Biblothek bekannt.");
		}
	}
}