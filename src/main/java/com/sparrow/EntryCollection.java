package com.sparrow;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

public class EntryCollection {

    public static ArrayList<JournalEntry> getEntries() {

        ArrayList<JournalEntry> entries = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("input"))) {
            for (Path path : stream) {
                String fullPath = path.getFileName().toString();
                int idx = fullPath.indexOf("-");
                String dateStr = fullPath.substring(idx + 1);
                dateStr = dateStr.substring(0, dateStr.length() - 3);
                entries.add(
                    new JournalEntry(
                        path, LocalDate.parse(dateStr), fullPath.substring(0, idx), "none"
                    )
                );
            }
        } catch (IOException e) {
            System.out.println("Make the folder please.");
        }

        return entries;

    }

}
