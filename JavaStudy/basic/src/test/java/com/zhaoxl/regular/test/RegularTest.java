package com.zhaoxl.regular.test;

import com.zhaoxl.regular.expression.RegularExpression;
import org.junit.Assert;
import org.junit.Test;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年05月31日上午16:08]
 */
public class RegularTest {


    @Test
    public void test(){
        boolean beginWithAlphabet = RegularExpression.isBeginWithAlphabet("B9090256");

        boolean notBeginWithAlphabet = RegularExpression.isBeginWithAlphabet("2B9090256");

        boolean beginWithAlphabetButMore = RegularExpression.isBeginWithAlphabet("BKLGJK9090256");

        Assert.assertTrue(beginWithAlphabet);
        Assert.assertTrue(!notBeginWithAlphabet);
        Assert.assertTrue(!beginWithAlphabetButMore);
    }
}
