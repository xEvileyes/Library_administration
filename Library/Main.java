import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		
		String pages;
		String author;
		String title;						
		
		Library library = new Library(); // kreiere eine Bilbothek		
		Scanner scanner = new Scanner(System.in); // Scanner initialisieren
		
		System.out.println("Schönen Guten Tag. Bitte Wählen Sie aus den folgenden Programmen aus:");
		boolean run = true;	
		while(run) {			
			boolean inputCheck = true;
			while(inputCheck) {
				try { // Vermeidung von Falsch Eingabe/Programm abstürzen bei Falsch Eingabe
					System.out.println("1. Möchten Sie ein Buch hinzufügen?");
					System.out.println("2. Möchten Sie sich alle Bücher anzeigen lassen?");
					System.out.println("3. Möchten Sie nach einem bestimmten Buch anhand des Titels suchen?");
					System.out.println("4. Möchten Sie nach einem bestimmten Author suchen?");
					System.out.println("5. Möchten Sie das Programm beenden?");					
					String response = scanner.nextLine();
					int convertedResponse = Integer.parseInt(response);
					
					switch(convertedResponse) {			
						case 1: // Ein Buch wird aufgenommen
							System.out.println("Geben Sie den Namen des Buches ein:");
							title = scanner.nextLine();
							
							System.out.println("Geben Sie den Namen des Authoren ein:");
							author = scanner.nextLine();
							
							System.out.println("Geben Sie die Anzahl der Seiten ein:");
							pages = scanner.nextLine();
							int convertedPages = Integer.parseInt(pages);									
							
							Book newBook = new Book(title,author,convertedPages); // erstellt ein neues Buch
							library.addBook(newBook);			
							System.out.println("Das Buch wurde in die Biblothek mit aufgenommen.");	
							
							System.out.println(); // Platzhalter in der Console für Übersicht
							System.out.println("Was möchten Sie als nächstes tun?");
							break;
				
						case 2: // Alle Informationen werden ausgegeben
							library.displayDetailBook();
							System.out.println(); // Platzhalter in der Console für Übersicht
							System.out.println("Was möchten Sie als nächstes tun?");
							break;
					
						case 3: // Der Titel wird gesucht
							System.out.println("Geben Sie den Namen des Buches ein, welches Sie suchen:");
							String searchTitle =scanner.nextLine();
							library.findBookByTitle(searchTitle);
							System.out.println(); // Platzhalter in der Console für Übersicht
							System.out.println("Was möchten Sie als nächstes tun?");
							break;
						
						case 4: // Author wird gesucht
							System.out.println("Geben Sie den Namen des Authoren ein, welchen Sie suchen:");
							String searchAuthor =scanner.nextLine();
							library.findBookByAuthor(searchAuthor);
							System.out.println(); // Platzhalter in der Console für Übersicht
							System.out.println("Was möchten Sie als nächstes tun?");
							break;
						
						case 5: // Programm beenden
							run = false;
							inputCheck = false;
							break;
						default:
							System.out.println("Tut uns leid diese Option gibt es leider nicht");
							System.out.println(); // Platzhalter in der Console für Übersicht
							System.out.println("Was möchten Sie als nächstes tun?");
					}				
				}				
				catch (NumberFormatException e) { // Fehlerbehandlung, wenn die Eingabe nicht converted werden kann
					System.out.println(); // Platzhalter in der Console für Übersicht
					System.out.println("Ungültige Eingabe! Bitte geben Sie eine gültige Zahl ein.");
					System.out.println(); // Platzhalter in der Console für Übersicht
				}
			}			
		}
		scanner.close();
		System.out.println("Das Programm wurde beendet");
	}
}
