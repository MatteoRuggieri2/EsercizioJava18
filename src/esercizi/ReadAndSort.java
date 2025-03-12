package esercizi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/* READ AND SORT
 * Crea la classe ReadAndSort
 * 1 - Leggere un file di testo con parole separate da 1 o più spazi (parola1 parola2  parol...)
 * 2 - Restituire una stringa con le parole senza duplicati in ordine ALFABETICO INVERSO */



public class ReadAndSort {
	
	private String filePath = "src/text_files/word-list.txt";
	
	private String fileContent; // Contiene il contenuto del file in una stringa
	
	private String[] fileWords;
	
	private String[] sortedFileWords; // Contiene le parole univoche e ordinate in base alla richiesta

	
	
	/* Questo metodo è quello principale, ha come compito quello
	 * di richiamare tutti gli altri metodi della classe che lavorano
	 * per rendere le parole del file, univoche, e ordinate (all'inverso - DESC). */
	private void extractsStrings(String filePath) {
		
		// Prendo il contenuto del file
		this.fileContent = readFile(filePath);
		
		// Prendo le parole del file. le separo e le rendo univoche
		this.fileWords = this.fileContent.split(" +");
		
		// Le ordino e le rendo univoche (grazie al TreeSet)
		sort();
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

	
	/* Questo metodo ordina le parole in modo inverso e
	le rende univoche (proprietà del TreeSet) */
	public void sort() {
		
		/* Esiste un costruttore di TreeSet che accetta come paramtro un Comparator
		 * (che è un interfaccia) dove io vado ad implementare un metodo compare,
		 * in modo che quando il mio treeSet dovrà mettere in ordine gli elementi,
		 * richiamerà il metodo che io ho scritto (che ha sovrascritto il suo).
		 * In questo caso c'è prima s2 e poi s1 in modo che li mette in ordine DESC. */
		Set<String> result = new TreeSet<String>(
			// Classe anonima
			new Comparator<String>() {
				public int compare(String s1, String s2) {
					// s1, s2 ordine alfabetico | s2, s1 ordine alf invertito
					return s2.compareTo(s1);
				}
			}
		);
		
		for (String word : this.fileWords) {
			result.add(word.toLowerCase());
		}
		
		this.sortedFileWords = result.toArray(new String[0]);
	}

}
























