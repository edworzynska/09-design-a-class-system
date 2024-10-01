
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryIntegrationTestTest {
    static Diary diary;
    DiaryEntry entry1;
    DiaryEntry entry2;
    DiaryEntry entry3;
    DiaryEntry entry4;
    DiaryEntry entry5;
    DiaryEntry entry6;
    @BeforeEach
    public void setUp(){
        diary = new Diary();
        entry1 = new DiaryEntry("1", "1doo 2bee 3doo 4bee");
        entry2 = new DiaryEntry("2", "5doo 6bee 7doo 8bee");
        entry3 = new DiaryEntry("3", "04567321327 9doo 10bee 11doo 12bee");
        entry4 = new DiaryEntry("4", "13doo 14bee 15doo 16bee");
        entry5 = new DiaryEntry("5", "17doo 18bee 19doo 20bee 04567321323 04567321324");
        entry6 = new DiaryEntry("6", "21doo 22bee 04567321321 23doo 24bee");
        diary.add(entry1);
        diary.add(entry2);
        diary.add(entry3);
        diary.add(entry4);
        diary.add(entry5);
        diary.add(entry6);
    }

    @Test
    void displaysEntries() {
        var entries = diary.displayAll();
        assertEquals("1\n1doo 2bee 3doo 4bee\n2\n5doo 6bee 7doo 8bee\n3\n04567321327 9doo 10bee 11doo 12bee\n4\n13doo 14bee 15doo 16bee\n5\n17doo 18bee 19doo 20bee 04567321323 04567321324\n6\n21doo 22bee 04567321321 23doo 24bee", entries);
    }

    @Test
    void extractsNumbersAndDisplaysPhonebook() {
        var phonebook = new PhoneBook();
        phonebook.extractNumbers(diary);
        var phones = phonebook.displayPhonebook();
        assertEquals("04567321327\n04567321323\n04567321324\n04567321321", phones);
    }
    @Test
    void clearsPhonebookAndThrowsAnErrorWhileDisplayingEmptyPhonebook() {
        var phonebook = new PhoneBook();
        phonebook.extractNumbers(diary);
        phonebook.clearPhonebook();
        RuntimeException pe = assertThrows(RuntimeException.class, phonebook::displayPhonebook);
        assertEquals("Phonebook is empty!", pe.getMessage());
    }

    @Test
    void phonebookIsClearByDefault() {
        var phonebook = new PhoneBook();
        RuntimeException pe = assertThrows(RuntimeException.class, phonebook::displayPhonebook);
        assertEquals("Phonebook is empty!", pe.getMessage());
    }



    @Test
    void addsEntriesAndFindsBestEntryForReadingTime() {
        var entry7 = new DiaryEntry("7", "25doo 26bee");
        diary.add(entry7);
        var bestEntry = diary.findBestEntryForReadingTime(2, 3);
        assertEquals(entry5, bestEntry);
        var bestEntry2 = diary.findBestEntryForReadingTime(1, 2);
        assertEquals(entry7, bestEntry2);
        var bestEntry3 = diary.findBestEntryForReadingTime(1, 1);
        assertEquals("No matching entries found!", bestEntry3);
    }
    @Test
    void bestEntryThrowsAnErrorIfValuesAreIncorrect() {
        RuntimeException e = assertThrows(RuntimeException.class, () -> diary.findBestEntryForReadingTime(-1, 1));
        RuntimeException e2 = assertThrows(RuntimeException.class, () -> diary.findBestEntryForReadingTime(1, -1));
        RuntimeException e3 = assertThrows(RuntimeException.class, () -> diary.findBestEntryForReadingTime(0, 0));
        assertEquals("Values should be positive numbers above 0!", e.getMessage());
        assertEquals("Values should be positive numbers above 0!", e2.getMessage());
        assertEquals("Values should be positive numbers above 0!", e3.getMessage());
    }

}