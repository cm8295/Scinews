package gov.lct.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("MyPasswordEncode")
public class MyPasswordEncode implements PasswordEncoder {
	private MD5 md5;

    @Autowired
    public void setMd5(@Qualifier("MD5") MD5 md5) {
        this.md5 = md5;
    }


    public String encodePassword(String rawPass, Object salt) {
        String salted = rawPass;
        return md5.md5s(salted);
    }


    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        if (encPass.equals(encodePassword(rawPass, salt))) {
            return true;
        }
        return false;
    }

}
