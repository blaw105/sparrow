package com.sparrow;

/**
 * Main class to run project
 */
public class Main {

    /**
     * Runs the project
     */
    public static void main(String[] args) {

        JournalRenderer renderer = new JournalRenderer();

        if (args.length > 0 && args[0].equals("--watch")) {
            renderer.watch();
        } else {
            renderer.render();
        }

    }

}
