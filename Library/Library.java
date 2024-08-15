import java.util.ArrayList;


public class Library {


	ArrayList<Book> books = new ArrayList<>();
	
		
	public Library() {		// erstellt eine Bücherei
	}	
	
	public void displayDetailBook() { // gibt alle Infos zu allen Büchern aus					
		for (Book book: books) {
		book.displayDetails();
		book.isLongBook();
		}	
	}
	
	public void addBook(Book book) {			
		books.add(book);			
	}
	
	public void findBookByTitle(String title) {		
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
	
	public void findBookByAuthor(String author) {		
		boolean noAuthor = true;
		for (Book book: books) {				
			if(book.getAuthor().equals(author)) {
				System.out.println("Der Author "+author+" ist in der Biblothek vorhanden mit dem Buch " + book.getTitle() +".");
				noAuthor = false;
			}			
		}
		if(noAuthor == true) {
			System.out.println("Es tut uns leid, wir haben kein Buch von dem Authoren "+author+" da.");
		}		
	}	
}
