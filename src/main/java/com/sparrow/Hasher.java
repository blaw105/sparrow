package com.sparrow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {

    public static byte[] hash(Path path) {

        byte[] bytes = null;

        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {}

        try {
            return MessageDigest.getInstance("MD5").digest(bytes);
        } catch (NoSuchAlgorithmException e) {
            return new byte[0];
        }

    }

}
