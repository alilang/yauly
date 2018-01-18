package com.cmgame.bridge;

public class Utils {

    private static native String encrypt(String plain);
    private static native String EncryptReq(String plain);

    static public String Encrypt(String plain) {
        if(plain != null) {
            return encrypt(plain);
        }
        return null;
    }

    static public String GetEncryptReq(String plain) {
        if(plain != null && plain.length() != 0) {
            return EncryptReq(plain);
        }
        return null;
    }

}
