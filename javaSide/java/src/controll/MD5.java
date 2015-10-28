package controll;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	private String hash = "";
	private String toMD5 = "";
	
	public MD5(String toMD5) {
		this.toMD5 = toMD5;
		this.hash = hash(toMD5);
	}
	
	public static String hash(String md5) {
		   try {
		        MessageDigest md = MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (NoSuchAlgorithmException e) {
		    }
		    return null;
		}
	
	public String getHash() {
		return this.hash;
	}
	
	public String getText() {
		return this.toMD5;
	}
	
	public void setText(String text) {
		this.toMD5 = text;
		this.hash = hash(text);
	}

}
