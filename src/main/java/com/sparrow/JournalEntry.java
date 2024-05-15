package com.sparrow;
import java.nio.file.Path;
import java.util.Date;

public class JournalEntry {
    private Path path;
    private Date entryDate;
    private String title;
    private String mood;

    public JournalEntry(Path p, Date ed, String t, String m) {
        path = p;
        entryDate = ed;
        title = t;
        mood = m;
    }

    // getter methods
    public Date getEntryDate() {
        return entryDate;
    }

    public Path getPath() {
        return path;
    }

    public String getTitle() {
        return title;
    }

    public String getMood() {
        return mood;
    }
}
