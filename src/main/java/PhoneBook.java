import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    public List<String> phonebook = new ArrayList<>();

    //
    public void extractNumbers(Diary diary){

        Pattern pattern = Pattern.compile("\\d{11}");
        String allContents = diary.displayAll();
        Matcher matcher = pattern.matcher(allContents);
        while (matcher.find()) {
            String extracted = matcher.group();
            phonebook.add(extracted);

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
