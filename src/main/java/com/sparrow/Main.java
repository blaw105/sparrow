package com.sparrow;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        Renderer r = new Renderer("main");

        try {
            r.renderTo();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        if (args.length > 0 && args[0].equals("--watch")) {
            while (true) {
                FileWatcher.watch(Paths.get("input/main.md"), 100);
                try {
                    r.renderTo();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }

}
