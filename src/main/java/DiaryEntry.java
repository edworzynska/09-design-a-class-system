public class DiaryEntry {

    public String title;
    public String contents;

    public DiaryEntry(String title, String contents){
        this.title = title;
        this.contents = contents;
        if (contents == null || contents.isEmpty()){
            throw new RuntimeException("String cannot be null!");
        }
    }

    private String getTitle() {
        return title;
    }

    private String getContents() {
        return contents;
    }

    public String displayEntry(){
        return getTitle() + "\n" + getContents();
    }

    public Integer countWords(){
        if (contents.isEmpty()) {
            return 0;
        }
        else{
            return contents.split(" ").length;
        }
    }
}
