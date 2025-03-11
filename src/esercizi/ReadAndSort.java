package esercizi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/* READ AND SORT
 * Crea la classe ReadAndSort
 * 1 - Leggere un file di testo con parole separate da 1 o più spazi (parola1 parola2  parol...)
 * 2 - Restituire una stringa con le parole senza duplicati in ordine ALFABETICO INVERSO */



public class ReadAndSort {
	
	private String pathFileName = "src/text_files/word-list.txt";
	
	private String fileContent;
	
	private Set<String> paroleUnicheInOrdineAlfabetico;
	
	private String[] splittedText;
	
	private String[] revertedWords;

	public static void main(String[] args) {
		ReadAndSort readAndSort = new ReadAndSort();
		readAndSort.run();
		
	}
	
	private void run() {
		
		/* Esiste un costruttore di TreeSet che accetta come paramtro un Comparator (che è un interfaccia)
		 * dove io vado ad implementare un metodo compare, in modo che quando il mio treeSet dovrà mettere
		 * in ordine gli elementi, richiamerà il metodo che io ho scritto (che ha sovrascritto il suo).
		 * In questo caso c'è prima s2 e poi s1 in modo che li mette in ordine contrario.
		 * 
		 * Nello specifico ecco come il comparator gestisce il suo ordinamento:
		 * ritorna un int -1 se deve spostare l'elemento indietro, 0 se deve rimanere al suo posto, 
		 * 1 se deve spostarlo avanti. */
		paroleUnicheInOrdineAlfabetico = new TreeSet<String>(
			// Classe anonima
			new Comparator<String>() {
				public int compare(String s1, String s2) {
					return s2.compareTo(s1);   // s1, s2 ordine alfabetico | s2, s1 ordine alf invertito
				}
			}
		);
		
	
		// Funzione che apre il file e restituisce il contenuto
		this.fileContent = readFile(this.pathFileName);
		
		// Splitto la stringa, elimino i doppioni e metto le parole in ordine ALFABETICO INVERTITO (ho sovrascritto l'ordinamento di default del TreeSet)
		splittaStringaEMettileInOrdineAlfabetico(fileContent);
		System.out.println("Parole in ordine: " + this.paroleUnicheInOrdineAlfabetico);

	}
	
	// Questa funzione prende il path del file, apre il file e ritorna una stringa con il contenuto
	private String readFile(String path) {
		
		String fileContentString = "";
		
		// Apro il file
		File inputFile = new File(path);
		
		// Leggo il file con lo scanner
		try {
			Scanner scanner = new Scanner(inputFile);
			
			// Salvo la stringa nativa dal file
			fileContentString = scanner.nextLine();
			scanner.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return fileContentString;
	}

	// Questa funzione splitta la stringa il separatore passati come argomenti
	private String[] splitString(String string, String separator) {
		return string.split(separator);
	}
	
	/* Questa funzione prende una stringa, la splitta e poi mette le parole dentro
	 * un treeSet, quindi toglie i duplicati e le mette in ordine alfabetico */
	private void splittaStringaEMettileInOrdineAlfabetico(String text) {
		
		
		// Splitto il testo
		this.splittedText = this.splitString(text, " +");
		
		// Inserisco le parole nel treeset (in automatico le ordina in ordine alfabetico)
		for (String word : this.splittedText) {
			this.paroleUnicheInOrdineAlfabetico.add(word.toLowerCase());
		}

	}

}
























