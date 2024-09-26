import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryIntegrationTestTest {
    @Test
    void addsEntriesExtractsNumbersAndDisplaysEntriesAndPhoneBook(){
        var diary = new Diary();
        var phonebook = new PhoneBook();
        var entry1 = new DiaryEntry("1", "1doo 2bee 3doo 4bee");
        var entry2 = new DiaryEntry("2", "5doo 6bee 7doo 8bee");
        var entry3 = new DiaryEntry("3", "04567321327 9doo 10bee 11doo 12bee");
        var entry4 = new DiaryEntry("4", "13doo 14bee 15doo 16bee");
        var entry5 = new DiaryEntry("5", "17doo 18bee 19doo 20bee 04567321323 04567321324");
        var entry6 = new DiaryEntry("6", "21doo 22bee 04567321321 23doo 24bee");
        diary.add(entry1);
        diary.add(entry2);
        diary.add(entry3);
        diary.add(entry4);
        diary.add(entry5);
        diary.add(entry6);
        phonebook.extractNumbers(diary);
        var phones = phonebook.displayPhonebook();
        assertEquals("04567321327\n04567321323\n04567321324\n04567321321", phones);
        var entries = diary.displayAll();
        assertEquals("1\n1doo 2bee 3doo 4bee\n2\n5doo 6bee 7doo 8bee\n3\n04567321327 9doo 10bee 11doo 12bee\n4\n13doo 14bee 15doo 16bee\n5\n17doo 18bee 19doo 20bee 04567321323 04567321324\n6\n21doo 22bee 04567321321 23doo 24bee", entries);
    }

    @Test
    void addsEntriesAndFindsBestEntryForReadingTime() {
        var diary = new Diary();
        var entry1 = new DiaryEntry("1", "1doo 2bee 3doo 4bee");
        var entry2 = new DiaryEntry("2", "5doo 6bee 7doo 8bee");
        var entry3 = new DiaryEntry("3", "04567321327 9doo 10bee 11doo 12bee");
        var entry4 = new DiaryEntry("4", "13doo 14bee 15doo 16bee");
        var entry5 = new DiaryEntry("5", "17doo 18bee 19doo 20bee 04567321323 04567321324");
        var entry6 = new DiaryEntry("6", "21doo 22bee 04567321321 23doo 24bee");
        var entry7 = new DiaryEntry("7", "25doo");
        diary.add(entry1);
        diary.add(entry2);
        diary.add(entry3);
        diary.add(entry4);
        diary.add(entry5);
        diary.add(entry6);
        diary.add(entry7);
        var bestEntry = diary.findBestEntryForReadingTime(2, 3);
        assertEquals("5\n17doo 18bee 19doo 20bee 04567321323 04567321324", bestEntry);
        var bestEntry2 = diary.findBestEntryForReadingTime(1,2);
        assertEquals("7\n25doo", bestEntry2);
        var bestEntry3 = diary.findBestEntryForReadingTime(1, 0);
        assertEquals("No matching entries found!", bestEntry3);
    }
    void addsTasksToDoMarksAsCompletedAndDisplaysCompletedAndTodoLists(){
        var diary = new Diary();
        var task1 = new ToDo("walk Gucci");
        var task2 = new ToDo("buy milk");
        var task3 = new ToDo("eat");
        var task4 = new ToDo("sleep");
        diary.addTask(task1);
        diary.addTask(task2);
        diary.markTaskAsCompleted(task1);
        var completed = diary.displayCompleted();
        assertEquals("Completed tasks: walk Gucci", completed);

    }
}