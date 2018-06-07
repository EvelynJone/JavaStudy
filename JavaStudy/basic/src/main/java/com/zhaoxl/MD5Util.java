//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zhaoxl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;



public class MD5Util {
    private static final Logger log = LoggerFactory.getLogger(MD5Util.class);
    private static MessageDigest messageDigest = null;

    public MD5Util() {
    }

    public static String md5(String srcStr) {
        StringBuffer md5StrBuff = new StringBuffer();

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(srcStr.getBytes("UTF-8"));
            byte[] byteArray = messageDigest.digest();

            for(int i = 0; i < byteArray.length; ++i) {
                if (Integer.toHexString(255 & byteArray[i]).length() == 1) {
                    md5StrBuff.append("0").append(Integer.toHexString(255 & byteArray[i]));
                } else {
                    md5StrBuff.append(Integer.toHexString(255 & byteArray[i]));
                }
            }
        } catch (Exception var4) {
            log.error("[MD5Util]", var4);
        }

        return md5StrBuff.toString();
    }
}
