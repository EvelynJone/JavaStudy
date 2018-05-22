package regular;

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
 * 1.[2018年05月22日上午19:27]
 */
public class RegularPattern {
    private static final Logger LOG = LoggerFactory.getLogger(RegularPattern.class);
    public static boolean regex(String regex,String input) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input).matches();
    }

    public static Matcher regexAndReturn(String regex,String input) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input);
    }

    public static void testFuzzyMatching1() {
        Matcher matcher = regexAndReturn("/ab{2,5}c/", "abc abbc abbbc abbbbc abbbbbc abbbbbbc");
        LOG.info("",matcher.group());
    }

    public static void main(String[] args) {
         testFuzzyMatching1();
    }
}
