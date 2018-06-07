//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zhaoxl;

import java.security.SecureRandom;

public class SnowflakeIdGen   {
    private long twepoch = 1288834974657L;
    private static final long IDBITS_WORKER = 6L;
    private static final long IDBITS_REGION = 4L;
    private static final long BITS_SEQUENCE = 12L;
    private static final long MAXID_REGION = 15L;
    private static final long MAXID_WORKER = 63L;
    private static final long MASK_SEQUENCE = 4095L;
    private static final long SHIFT_WORKERID = 12L;
    private static final long SHIFT_REGIONID = 18L;
    private static final long SHIFT_TIMESTAMP = 22L;
    private static long lastTimestamp = -1L;
    private long sequence = 0L;
    private final long workerId;
    private final long regionId;

    public SnowflakeIdGen(long workerId, long regionId) {
        if (workerId <= 63L && workerId >= 0L) {
            if (regionId <= 15L && regionId >= 0L) {
                this.workerId = workerId;
                this.regionId = regionId;
            } else {
                throw new IllegalArgumentException("datacenter Id can't be greater than %d or less than 0");
            }
        } else {
            throw new IllegalArgumentException("worker Id can't be greater than %d or less than 0");
        }
    }

    public SnowflakeIdGen(long workerId) {
        if (workerId <= 63L && workerId >= 0L) {
            this.workerId = workerId;
            this.regionId = 0L;
        } else {
            throw new IllegalArgumentException("worker Id can't be greater than %d or less than 0");
        }
    }

    public Long id() {
        return this.nextId();
    }

    private synchronized long nextId() {
        long timestamp = this.timeGen();
        if (timestamp < lastTimestamp) {
            try {
                throw new Exception("Clock moved backwards.  Refusing to generate id for " + (lastTimestamp - timestamp) + " milliseconds");
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        }

        if (lastTimestamp == timestamp) {
            this.sequence = this.sequence + 1L & 4095L;
            if (this.sequence == 0L) {
                timestamp = this.tailNextMillis(lastTimestamp);
            }
        } else {
            this.sequence = (long)(new SecureRandom()).nextInt(10);
        }

        lastTimestamp = timestamp;
        return timestamp - this.twepoch << 22 | this.regionId << 18 | this.workerId << 12 | this.sequence;
    }

    private long tailNextMillis(long lastTimestamp) {
        long timestamp;
        do {
            Thread.yield();
            timestamp = this.timeGen();
        } while(timestamp <= lastTimestamp);

        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        // 获取机器ID,获取regionID
        String[] macs = HardwareUtil.listMac();
        if (0 == macs.length) {
            return;
        }
        System.out.println(macs[0]);

        SnowflakeIdGen gen =new SnowflakeIdGen(26,0);
        System.out.println(gen.id());
    }
}
