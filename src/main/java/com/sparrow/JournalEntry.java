package com.sparrow;

import java.nio.file.Path;
import java.time.LocalDate;

public class JournalEntry {

    private Path path;
    private LocalDate entryDate;
    private String title;
    private String mood;

    public JournalEntry(Path p, LocalDate ed, String t, String m) {

        path = p;
        entryDate = ed;
        title = t;
        mood = m;

    }

    public LocalDate getEntryDate() {

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
