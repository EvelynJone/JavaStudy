package com.zhaoxl.regular.expression;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年05月31日上午16:06]
 */
public class RegularExpression {

    private static final Logger LOG = LoggerFactory.getLogger(RegularExpression.class);

    /**
     * 是否以字母开头
     * @param input
     * @return
     */
    public static boolean isBeginWithAlphabet(String input) {
        Pattern pattern = Pattern.compile("^[A-Z].[0-9]*");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            if (LOG.isInfoEnabled()) {
                int groupCount = matcher.groupCount();
                for (int i = 0; i < groupCount; i++) {
                    LOG.info("input:{} , and match result : {} ",input,matcher.group(i));
                }
            }
            return true;
        }
        return false;
    }

}
