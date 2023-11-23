package Heliosz_Service;

import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.sun.istack.NotNull;

public class Login_PWD_encryp {

	private static final String CHARSET_NAME = "UTF-8";
	
	private static final String AES_NAME = "AES";
	// encryption mode
	public static final String ALGORITHM = "AES/CBC/PKCS7Padding";
	// Key
	public static final String KEY = "T@k3-m3-t0-tH3-3dg3-$H-2020-p@$$";
	// Offset
	public static final String IV = "Srinsoft@1234567";
     static {
		
		Security.addProvider(new BouncyCastleProvider());
	}
	
	public static String encrypt(@NotNull String content,boolean base64) {
		byte[] result = null;
		try {
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(CHARSET_NAME), AES_NAME);
			AlgorithmParameterSpec paramSpec = new IvParameterSpec(IV.getBytes());
			//System.out.println(paramSpec);
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, paramSpec);
			result = cipher.doFinal(content.getBytes(CHARSET_NAME));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return content;
		return Base64.encodeBase64String(result);
		
	}
	public static void main(String[] args) {
		
		   System.out.println(encrypt("Oct@123456", false));

	       System.out.println(IV.getBytes().length);
	}

}
