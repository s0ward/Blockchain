package com.company.client.app.util;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public final class Hasher {

    private static final String HASHING_ALGORITHM = "SHA-256";
    private static MessageDigest digest = getMessageDigest();

    public static String hash(String originalString) {
        byte[] encodedHash = Objects.requireNonNull(digest).digest(
            originalString.getBytes(StandardCharsets.UTF_8));

        return bytesToHex(encodedHash);
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance(HASHING_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return digest;
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
