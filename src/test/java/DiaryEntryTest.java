import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryEntryTest {
    @Test
    void countsWordsInEntries() {
        var entry1 = new DiaryEntry("1","17doo 18bee 19doo 20bee 04567321323 04567321324");
        var entry1l = entry1.countWords();
        assertEquals(6, entry1l);
    }
}