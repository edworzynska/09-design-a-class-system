import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    private final List<String> phonebook = new ArrayList<>();

    public List<String> getPhonebook() {
        return phonebook;
    }

    public void extractNumbers(Diary diary){
        if (diary.getDiary().isEmpty()){
            throw new RuntimeException("Your diary is empty!");
        }
        final String regex = "\\d{11}";
        Pattern pattern = Pattern.compile(regex);

        for (DiaryEntry entry : diary.getDiary()){
            Matcher matcher = pattern.matcher(entry.displayEntry());
            while (matcher.find()) {
                String extracted = matcher.group();
                phonebook.add(extracted);
            }
        }
    }
    public String displayPhonebook(){
        if (phonebook.isEmpty()){
            throw new RuntimeException("Phonebook is empty!");
        }
        return String.join("\n", phonebook);
    }
    public void clearPhonebook(){
        phonebook.clear();
    }
}
