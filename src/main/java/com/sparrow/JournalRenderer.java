package com.sparrow;

import java.io.IOException;

/**
 * A class that renders all the journals
 */
public class JournalRenderer {

    /**
     * Renders all the files
     */
    public void render() {

        for (JournalEntry x : EntryCollection.getEntries()) {
            try {
                String str = x.getPath().getFileName().toString();
                str = str.substring(0, str.length() - 3);
                new Renderer(str, x.getTitle()).renderTo();
            } catch (IOException e) {}
        }

    }

    /**
     * Watches for reloads and rerenders
     */
    public void watch() {

        render();

        while (true) {
            FileWatcher.watch(250);
            render();
        }

    }

}
