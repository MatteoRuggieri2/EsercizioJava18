package esercizi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ReadAndSortTest {

	static ReadAndSort readAndSort;
	String pathFileName = "src/text_files/word-list.txt";
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		readAndSort = new ReadAndSort();
	}

	@Test
	void testReadFile() {
		// Non va perchè il metodo è private nella classe, quindi è visibile solo per quella classe
		assertEquals("Queste sono   sono delle parole", readAndSort.readFile(pathFileName));
	}

}