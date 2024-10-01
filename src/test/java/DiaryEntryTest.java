import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryEntryTest {
    DiaryEntry entry;
    DiaryEntry entry2;
    @BeforeEach
    void setUp(){
        entry = new DiaryEntry("title", "doo bee doo bee");
        entry2 = new DiaryEntry("header", "some contents in the body of the diary entry");
    }
    @Test
    void countsWordsInEntry() {
        var entryLength = entry.countWords();
        assertEquals(4, entryLength);
    }

    @Test
    void countsWordsInEntry2() {
        var entryLength = entry2.countWords();
        assertEquals(9, entryLength);
    }

    @Test
    void throwsAnErrorWhenInitiatingEmptyEntry() {
        RuntimeException r = assertThrows(RuntimeException.class, ()-> new DiaryEntry("", ""));
        assertEquals("String cannot be null!", r.getMessage());
    }

    @Test
    void displaysEntry() {
        var displayed = entry.displayEntry();
        assertEquals("title\ndoo bee doo bee", displayed);
    }
}