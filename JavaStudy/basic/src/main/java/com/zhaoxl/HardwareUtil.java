//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zhaoxl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.UUID;

public class HardwareUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(HardwareUtil.class);

    public HardwareUtil() {
    }

    public static String getEquipId() {
        String result = "";
        Enumeration netInterfaces = null;

        try {
            netInterfaces = NetworkInterface.getNetworkInterfaces();

            while(netInterfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface)netInterfaces.nextElement();
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                if (ips.hasMoreElements()) {
                    String _localMAC = getLocalMAC((InetAddress)ips.nextElement());
                    result = MD5Util.md5(_localMAC);
                }
            }

            return result;
        } catch (SocketException var5) {
            var5.printStackTrace();
            return result;
        }
    }

    public static String getDynamicEquipId() {
        String _localMAC = "";
        Enumeration netInterfaces = null;

        try {
            netInterfaces = NetworkInterface.getNetworkInterfaces();

            while(netInterfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface)netInterfaces.nextElement();
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                if (ips.hasMoreElements()) {
                    _localMAC = getLocalMAC((InetAddress)ips.nextElement());
                }
            }

            StringBuilder dynamic = new StringBuilder();
            dynamic.append(_localMAC).append((new Date()).toString()).append(UUID.randomUUID().toString());
            return MD5Util.md5(dynamic.toString());
        } catch (SocketException var4) {
            var4.printStackTrace();
            return "";
        }
    }

    public static String getLocalMAC() {
        String result = "";
        Enumeration netInterfaces = null;

        try {
            netInterfaces = NetworkInterface.getNetworkInterfaces();

            while(netInterfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface)netInterfaces.nextElement();
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                if (ips.hasMoreElements()) {
                    String _localMAC = getLocalMAC((InetAddress)ips.nextElement());
                    result = _localMAC;
                }
            }

            return result;
        } catch (SocketException var5) {
            var5.printStackTrace();
            return result;
        }
    }

    private static String getLocalMAC(InetAddress ia) throws SocketException {
        byte[] macByte = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
        StringBuffer sb = new StringBuffer();
        if (null != macByte) {
            for(int i = 0; i < macByte.length; ++i) {
                if (i != 0) {
                    sb.append(":");
                }

                String s = Integer.toHexString(macByte[i] & 255);
                sb.append(s.length() == 1 ? 0 + s : s);
            }
        }

        return sb.toString().toUpperCase();
    }

    public static String[] listMac()   {
        Enumeration nis;
        try {
            nis = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException var4) {
            LOGGER.error("get network interface failed.", var4);
            throw new RuntimeException(var4);
        }

        HashSet macs = new HashSet();

        try {
            while(nis.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface)nis.nextElement();
                if (null != ni && !ni.isLoopback() && !ni.isVirtual() && ni.isUp()) {
                    String mac = Coder.BINARY.encode(ni.getHardwareAddress());
                    macs.add(mac);
                }
            }
        } catch (SocketException var5) {
            LOGGER.error("filter network interface failed.", var5);
            throw new RuntimeException(var5);
        }

        String[] r = new String[macs.size()];
        return (String[])macs.toArray(r);
    }
}
