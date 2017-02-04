package connection;

/**
 * Created by maciek on 23.01.17.
 */
public class News {

    public News() {
    }

    public News(String highlight, String title, String content) {
        this.highlight = highlight;
        this.title = title;
        this.content = content;
    }

    private String highlight;
    private String title;
    private String content;

    public String getHighlight() {
        return highlight;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

}
