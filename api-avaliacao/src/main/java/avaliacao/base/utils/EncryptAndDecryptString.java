package avaliacao.base.utils;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class EncryptAndDecryptString {

    public static String decrypt(String secretKey, String encrypted)
            throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] iv = DatatypeConverter.parseBase64Binary(encrypted.substring(0, 24));
        Cipher cipher = getCipher();
        cipher.init(Cipher.DECRYPT_MODE, getKeySpec(secretKey), new IvParameterSpec(iv));
        byte[] original = cipher.doFinal(DatatypeConverter.parseBase64Binary(encrypted.substring(24)));
        return new String(original);
    }

    private static SecretKeySpec getKeySpec(String secretKey)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return new SecretKeySpec(digest.digest(secretKey.getBytes("UTF-8")), "AES");
    }

    private static Cipher getCipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    public static String encrypt(String secretKey, String plaintext)
            throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] iv = new byte[16];
        SecureRandom.getInstanceStrong().nextBytes(iv);
        Cipher cipher = getCipher();
        cipher.init(Cipher.ENCRYPT_MODE, getKeySpec(secretKey), new IvParameterSpec(iv));
        byte[] encrypted = cipher.doFinal(plaintext.getBytes());
        return DatatypeConverter.printBase64Binary(iv) + DatatypeConverter.printBase64Binary(encrypted);
    }

    // used for quick encrypt
    public static void main(String[] args) throws Exception {
    	String key = "7Pj1s2JRldJNYdmq";
    	System.out.println(encrypt(key, "jdbc:sqlserver://ENOTE-FBM\\DEV;databaseName=Hackathon"));
    	System.out.println(encrypt(key, "sa"));
    	System.out.println(encrypt(key, "Mapueha2601"));
    }
}