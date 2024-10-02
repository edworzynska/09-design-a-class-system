

import java.util.ArrayList;
import java.util.List;

public class Diary {
    private final List<DiaryEntry> diary;
    public Diary() {
        diary = new ArrayList<>();
    }
    public List<DiaryEntry> getDiary() {
        return diary;
    }

    public void add(DiaryEntry entry){
        diary.add(entry);
    }

    public String displayAll(){

        StringBuilder diaryContents = new StringBuilder();
        if (diary.isEmpty()){
            throw new RuntimeException("Your diary is empty!");
        }
        else {
            for (DiaryEntry entry : diary) {
                diaryContents.append(entry.displayEntry());
                if (entry != diary.getLast()) {
                    diaryContents.append("\n");
                }
            }
        }
        return diaryContents.toString();
    }
    public Object findBestEntryForReadingTime(int wpm, int minutes){
        if (wpm <= 0 || minutes <= 0){
            throw new RuntimeException("Values should be positive numbers above 0!");
        }
        int maxWords = wpm * minutes;
        DiaryEntry entryToRead = null;
        int closestWordCount = 0;
        for (DiaryEntry entry : diary){
            int wordCount = entry.countWords();
            if (wordCount <= maxWords && wordCount > closestWordCount){
                closestWordCount = wordCount;
                entryToRead = entry;
            }
        }
        return entryToRead != null? entryToRead : "No matching entries found!";
    }
    public String readEntry(DiaryEntry entry){
        return entry.displayEntry();
    }
}
