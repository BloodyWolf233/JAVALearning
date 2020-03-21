package ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password){
       return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password="123";
        String pwd1 = encodePassword(password);
        String pwd2 = encodePassword(password);
        System.out.println(pwd1+"\n"+pwd2);
//        $2a$10$Y6JYES2ikLaMdXhybez/POumXNFTouQD/SWAHAMxZTKK.hRJRMQci
//        $2a$10$v.DOg8zltPrBG.qt7lll4ey4bgE6NEGOrfNd8NwvOGNSNf4sSsG2.
    }
}
