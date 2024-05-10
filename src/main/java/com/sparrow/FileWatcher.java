package com.sparrow;

import java.nio.file.Path;

public class FileWatcher {

    public static void watch(Path path, int timeout) {

        byte[] hash = Hasher.hash(path);

        while (true) {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {}
            if (Hasher.hash(path) != hash) {
                break;
            }
        }

    }

}
