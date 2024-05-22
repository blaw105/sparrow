package com.sparrow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {

    public static String hash(Path path) {

        byte[] bytes = null;

        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {}

        try {
            return convert(MessageDigest.getInstance("MD5").digest(bytes));
        } catch (NoSuchAlgorithmException e) {
            return "";
        }

    }

    private static String convert(byte[] hash) {

        StringBuilder builder = new StringBuilder();

        for (byte x : hash) {
            builder.append(String.format("%02x", x));
        }

        return builder.toString();

    }

}
