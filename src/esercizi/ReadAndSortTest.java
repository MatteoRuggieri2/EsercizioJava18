package esercizi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ReadAndSortTest {

	@Test
	void readAndSortTest() {
		ReadAndSort ras = new ReadAndSort();
		String expectedString = "SONO, QUESTE, PAROLE, DELLE.";
		assertEquals(expectedString, ras.getWordsString());
	}

}