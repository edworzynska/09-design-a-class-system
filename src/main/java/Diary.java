import java.util.ArrayList;
import java.util.List;

public class Diary {
    public List<DiaryEntry> diary = new ArrayList<>();
    ToDo todo = new ToDo();

    public void add(DiaryEntry entry){
        diary.add(entry);
    }
    public String displayAll(){
        if (diary.isEmpty()){
            throw new RuntimeException("Your diary is empty!");
        }
        else {
            StringBuilder diaryContents = new StringBuilder();
            for (DiaryEntry entry : diary) {
                diaryContents.append(entry.getTitle());
                diaryContents.append("\n");
                diaryContents.append(entry.getContents());
                if (entry != diary.getLast()) {
                    diaryContents.append("\n");
                }
            }
            return diaryContents.toString();
        }
    }

    public String findBestEntryForReadingTime(int wpm, int minutes){
        if (wpm <= 0 || minutes <= 0){
            throw new RuntimeException("Values should be positive numbers above 0!");
        }
        int maxWords = wpm * minutes;
        String entryToRead = "";
        int closesWordCount = 0;
        for (DiaryEntry entry : diary){
            int wordCount = entry.countWords();
            if (wordCount <= maxWords && wordCount > closesWordCount){
                closesWordCount = wordCount;
                entryToRead = entry.getTitle() + "\n" + entry.getContents();
            }
        }
        return !entryToRead.isEmpty() ? entryToRead : "No matching entries found!";
    }
    public void addTask(String task){
        todo.addTask(task);
    }
    public void markAsCompleted(String task){
        todo.markAsCompleted(task);
    }
    public String displayCompleted(){
        return todo.displayCompleted();
    }
    public String displayIncomplete(){
        return todo.displayTasks();
    }
}
