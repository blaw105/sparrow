package com.sparrow;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class FileWatcher {

    public static void watch(int timeout) {

        HashMap<Path, byte[]> hashes = new HashMap<>();
        ArrayList<JournalEntry> entries = EntryCollection.getEntries();

        for (JournalEntry x : entries) {
            hashes.put(x.getPath(), Hasher.hash(x.getPath()));
        }

        while (true) {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {}
            for (JournalEntry x : entries) {
                if (Hasher.hash(x.getPath()) != hashes.get(x.getPath())) {
                    break;
                }
            }
        }

    }

}
