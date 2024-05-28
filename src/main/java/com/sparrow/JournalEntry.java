package com.sparrow;
import java.nio.file.Path;
import java.time.LocalDate;

public class JournalEntry implements Comparable<JournalEntry> {
    private Path path;
    private LocalDate entryDate;
    private String title;
    private String mood;

    /**
     * Basic constructor to assign private values
     * @param p File path of the JournalEntry
     * @param ed Entry date of the Journal Entry
     * @param t Title of the file
     * @param m Mood as a string
     */
    public JournalEntry(Path p, LocalDate ed, String t, String m) {
        path = p;
        entryDate = ed;
        title = t;
        mood = m;
    }

    // getter methods
    /**
     * Gets entry date
     * @return date
     */
    public LocalDate getEntryDate() {
        return entryDate;
    }

    /**
     * Gets file path
     * @return path
     */
    public Path getPath() {
        return path;
    }

    /**
     * Gets title
     * @return String of file name
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets mood
     * @return String of the mood
     */
    public String getMood() {
        return mood;
    }

    public int compareTo(JournalEntry other) {

        return entryDate.compareTo(other.entryDate);

    }

}
