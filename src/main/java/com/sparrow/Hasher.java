package com.sparrow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {

    /**
     * Hashes the file pointed to by path
     *
     * @param path The path of the file
     *
     * @return A String representing the hash
     */
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

    /**
     * Converts a byte array into a hex representation
     *
     * @param hash The given hash
     *
     * @return The hex representation
     */
    private static String convert(byte[] hash) {

        StringBuilder builder = new StringBuilder();

        for (byte x : hash) {
            builder.append(String.format("%02x", x));
        }

        return builder.toString();

    }

}
