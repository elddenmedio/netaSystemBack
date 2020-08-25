/**
 * 
 */
package com.neta.bk.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author elddenmedio
 *
 */
public class Encryption {
	private static final String ENCRYPT_ALGO = "AES/GCM/NoPadding";
    private static final int TAG_LENGTH_BIT = 128;
    private static final int IV_LENGTH_BYTE = 12;
    private static final int AES_KEY_BIT = 256;

    private static final Charset UTF_8 = StandardCharsets.UTF_8;

	public static String decrypt(String strToDecrypt, String secret) {
		try {
			return new String(strToDecrypt);
		} catch (Exception e) {
			System.out.println("Error while decrypting: " + e.toString());

			return null;
		}
	}
}
