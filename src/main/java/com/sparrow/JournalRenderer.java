package com.sparrow;

import java.io.IOException;

public class JournalRenderer {

    public void render() {

        System.out.println("RENDER??");

        for (JournalEntry x : EntryCollection.getEntries()) {
            System.out.println("entry: " + x.getTitle());
            try {
                String str = x.getPath().getFileName().toString();
                str = str.substring(0, str.length() - 3);
                System.out.println("str: " + str);
                new Renderer(str, x.getTitle()).renderTo();
            } catch (IOException e) {}
        }

    }

    public void watch() {

        while (true) {
            FileWatcher.watch(250);
            render();
        }

    }

}
