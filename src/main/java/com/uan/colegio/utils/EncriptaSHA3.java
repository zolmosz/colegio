package com.uan.colegio.utils;

import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.stereotype.Service;

@Service
public class EncriptaSHA3 {
	public String getEncriptaSHA3_512(String input) {
		try {
			String encodedText;
			SHA3.DigestSHA3 digestSHA3 = new SHA3.Digest512();
			byte[] digest = digestSHA3.digest(input.getBytes());

			encodedText = Hex.toHexString(digest);

			return encodedText;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private String String(byte[] encoded) {
		throw new UnsupportedOperationException("Operación no soportada."); // To change body of generated methods,
																			// choose Tools | Templates.
	}
}
