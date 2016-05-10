package gov.lct.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author  Albert Lau
 *          email: albertlau84@gmail.com
 * @date 2012-5-9
 * md5
 */
@Component("MD5")
public class MD5 {
	public static void main(String[] args){
	    Md5PasswordEncoder md5 = new Md5PasswordEncoder();  
	    System.out.println( md5.encodePassword("123456", ""));  
	    md5s("123456");
	}

	public static String md5s(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
//			System.out.println("result: " + buf.toString());// 32λ�ļ���
//			System.out.println("result: " + buf.toString().substring(8, 24));// 16λ�ļ���
			String string = buf.toString();
			//��Сд��Ӣ����ĸȫ��ת�ɴ�д��
			for(int k = 0; k < string.length(); k++){
				char  c = string.charAt(k);
				if(c>='a'&&c<='z'){
					string = string.replace(c, (char)(c-32));
				}
			}
//			System.out.println(string);
			return string;
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "error";
		}
	}
}
