import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    @Test
    void throwsAnErrorIfDiaryIsEmpty() {
        var phone = new PhoneBook();
        var diary = new Diary();
        RuntimeException r = assertThrows(RuntimeException.class,()-> phone.extractNumbers(diary));
        assertEquals("Your diary is empty!", r.getMessage());

    }

    @Test
    void addsElementsToListAndDisplays() {
        var phone = new PhoneBook();
        phone.getPhonebook().add("4567890789");
        phone.getPhonebook().add("1000000000");
        phone.getPhonebook().add("11111111111");
        var result = phone.displayPhonebook();
        assertEquals("4567890789\n1000000000\n11111111111", result);
    }

    @Test
    void throwsAnErrorWhenTryingToDisplayEmptyPhonebook() {
        var phone = new PhoneBook();
        RuntimeException r = assertThrows(RuntimeException.class, phone::displayPhonebook);
        assertEquals("Phonebook is empty!", r.getMessage());
    }
}