package com.sparrow;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class FileWatcher {

    public static void watch(int timeout) {

        HashMap<Path, String> hashes = new HashMap<>();
        ArrayList<JournalEntry> entries = EntryCollection.getEntries();

        for (JournalEntry x : entries) {
            hashes.put(x.getPath(), Hasher.hash(x.getPath()));
        }

        System.out.println("hashes: " + hashes);

        boolean done = false;

        while (!done) {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {}
            for (JournalEntry x : entries) {
                done |= !Hasher.hash(x.getPath()).equals(hashes.get(x.getPath()));
            }
        }

    }

}
