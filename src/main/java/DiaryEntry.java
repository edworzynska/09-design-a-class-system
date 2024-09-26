public class DiaryEntry {

    public String title;
    public String contents;

    public DiaryEntry(String title, String contents){
        this.title = title;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }
    public Integer countWords(){
        if (contents == null){
            throw new RuntimeException("String cannot be null!");
        }
        if (contents.isEmpty()) {
            return 0;
        }
        else{
            return contents.split(" ").length;
        }
    }
}
