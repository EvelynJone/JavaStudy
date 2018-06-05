

package com.zhaoxl.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public abstract class AssertSupport {
    private static final Logger LOGGER = LoggerFactory.getLogger(AssertSupport.class);

    public AssertSupport() {
    }

    public static void checkPoint(boolean checked, String msg, Object... args) {
        if (!checked) {
            LOGGER.warn(msg, args);
            LOGGER.warn("check point:", new Throwable());
        }

    }

    public static <T, E extends Exception> T assertNotnull(T t, E e) throws E {
        assertTrue(null != t, e);
        return t;
    }

    public static <T, E extends Exception> void assertNull(T t, E e) throws E {
        assertTrue(null == t, e);
    }

    public static <E extends Exception> void assertAllNotnull(E e, Object... ts) throws E {
        Object[] var2 = ts;
        int var3 = ts.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Object t = var2[var4];
            assertNotnull(t, e);
        }

    }

    public static <E extends Exception> void assertNotallNull(E e, Object... ts) throws E {
        Object[] var2 = ts;
        int var3 = ts.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Object t = var2[var4];
            if (null != t) {
                return;
            }
        }

        throw e;
    }

    public static <T, E extends Exception> Collection<T> assertNotnull(Collection<T> t, E e) throws E {
        assertTrue(null != t && !t.isEmpty(), e);
        return t;
    }

    public static <T, E extends Exception> void assertNull(Collection<T> t, E e) throws E {
        assertTrue(null == t || t.isEmpty(), e);
    }

    public static <T, E extends Exception> T[] assertNotnull(T[] t, E e) throws E {
        assertTrue(null != t && t.length > 0, e);
        return t;
    }

    public static <T, E extends Exception> void assertNull(T[] t, E e) throws E {
        assertTrue(null == t || 0 == t.length, e);
    }

    public static <E extends Exception> String assertNotnull(String t, E e) throws E {
        assertTrue(!StringUtils.isEmpty(t), e);
        return t;
    }

    public static <E extends Exception> String assertNull(String t, E e) throws E {
        assertTrue(StringUtils.isEmpty(t), e);
        return t;
    }

    public static <E extends Exception> void assertAllNotnull(E e, String... ts) throws E {
        String[] var2 = ts;
        int var3 = ts.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String t = var2[var4];
            assertNotnull(t, e);
        }

    }

    public static <E extends Exception> void assertNotallNull(E e, String... ts) throws E {
        String[] var2 = ts;
        int var3 = ts.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String t = var2[var4];
            if (!StringUtils.isEmpty(t)) {
                return;
            }
        }

        throw e;
    }

    public static <E extends Exception> void assertTrue(boolean value, E e) throws E {
        if (!value) {
            throw e;
        }
    }
}
