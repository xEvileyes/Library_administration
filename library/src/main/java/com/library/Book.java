package com.library;

public class Book {
	
	final private String title;
	final private String author;
	final private int pages;
	//final int LONGBOOK = 300;
	
	public Book(String title, String author, int pages) {
		this.title = title;
		this.author = author;
		this.pages = pages;
	}
	
	public void displayDetails() {
		System.out.println("Das Buch heißt "+title+" und wurde von "+author+" geschrieben. Das Buch hat "+pages+" Seiten.");		
	}
	
	public void displayTitle() {
		System.out.println(title);
	}
		
	/*public void isLongBook() {
		if (pages > LONGBOOK) {
			System.out.println("Das Buch zählt zu den langen Büchern, denn es hat mehr als "+LONGBOOK+" Seiten." );
			System.out.println();
		}
		else {
			System.out.println("Das Buch zählt nicht zu den langen Büchern, denn es hat weniger als "+LONGBOOK+" Seiten.");
			System.out.println();
		}
	}*/
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	public int getPages() {
		return pages;
	}
}