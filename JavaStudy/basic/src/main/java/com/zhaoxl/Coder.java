//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zhaoxl;

public enum Coder implements IStringCoder {

    BINARY(new BinaryCoder());

    private IStringCoder coder;

    private Coder(IStringCoder coder) {
        this.coder = coder;
    }

    public String encode(byte[] data) {
        try {
            return this.coder.encode(data);
        } catch (Exception var3) {
            return null;
        }
    }

    public byte[] decode(String data) {
        try {
            return this.coder.decode(data);
        } catch (Exception var3) {
            return null;
        }
    }
}
