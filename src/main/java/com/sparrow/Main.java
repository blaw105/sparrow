package com.sparrow;

public class Main {

    public static void main(String[] args) {

        JournalRenderer renderer = new JournalRenderer();

        if (args.length > 0 && args[0].equals("--watch")) {
            renderer.watch();
        } else {
            renderer.render();
        }

    }

}
