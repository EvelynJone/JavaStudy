//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zhaoxl;


import org.apache.commons.lang3.StringUtils;

public class BinaryCoder implements IStringCoder {
    private static final char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public BinaryCoder() {
    }

    public String encode(byte[] data) {
        StringBuilder sb = new StringBuilder();
        byte[] var3 = data;
        int var4 = data.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            byte i = var3[var5];
            sb.append(hexDigits[i >>> 4 & 15]);
            sb.append(hexDigits[i & 15]);
        }

        return sb.toString();
    }

    public byte[] decode(String data) {
        if (StringUtils.isEmpty(data)) {
            return new byte[0];
        } else {
            if (0 != data.length() % 2) {
                data = '0' + data;
            }

            byte[] output = new byte[data.length() / 2];
            int i = 0;

            for(int var4 = 0; i < data.length() - 1; i += 2) {
                output[var4++] = (byte)Integer.parseInt(data.substring(i, i + 2), 16);
            }

            return output;
        }
    }
}
