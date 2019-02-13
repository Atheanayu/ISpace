package Ispace01.service;

import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityImpl{
    public static String EncoderByMD5(String str){
        String newstr = "";
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            newstr = base64Encoder.encode(md5.digest(str.getBytes(StandardCharsets.UTF_8)));
        }catch (NoSuchAlgorithmException e1){
            e1.printStackTrace();
        }
        return newstr;
    }
}
