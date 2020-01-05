package data;

import javafx.beans.property.SimpleStringProperty;

public class Novel {
    private final SimpleStringProperty title,link,lastUpdateDate,chapter;

    public Novel(String title, String link, String lastUpdateDate, String chapter) {
        this.title = new SimpleStringProperty(title);
        this.link = new SimpleStringProperty(link);
        this.lastUpdateDate = new SimpleStringProperty(lastUpdateDate);
        this.chapter = new SimpleStringProperty(chapter);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public String getLink() {
        return link.get();
    }

    public SimpleStringProperty linkProperty() {
        return link;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate.get();
    }

    public SimpleStringProperty lastUpdateDateProperty() {
        return lastUpdateDate;
    }

    public String getChapter() {
        return chapter.get();
    }

    public SimpleStringProperty chapterProperty() {
        return chapter;
    }
}
