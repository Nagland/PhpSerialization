/**
 * Project Name: PhpSerialization
 * Package cn.stackbox.phpserialize;
 * Date: 2016-06-16 11:11
 */
package cn.stackbox.phpserialize;

import com.alibaba.fastjson.JSONObject;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: PdmiSerialization
 * Reason: SomeReason
 * Date: 2016-06-16 11:11
 *
 * @author SRK.Lyu (superalsrk@gmail.com)
 */
public class PdmiSerialization {


    private static Pattern PATTERN_TOKEN_STRING = Pattern.compile("^s:(\\d+):\"([\\s\\S]+)\";$");

    private static Pattern PATTERN_TOKEN_ARRAY = Pattern.compile("^a:(\\d+):");



    public static String unserializeString(String serializedString) {

        Matcher matcher = PATTERN_TOKEN_STRING.matcher(serializedString);
        if(matcher.matches() && matcher.groupCount() == 2) {
            return matcher.group(2);
        } else {
            return null;
        }
    }

    public static void unserialize(String serializedString) throws IllegalStateException {
        StringTokenizer varTokens = new StringTokenizer(serializedString, "{};");
        while (varTokens.hasMoreTokens()) {
            System.out.println(varTokens.nextToken() + ";");
        }
    }

    public static JSONObject decodeObject() {
        return new JSONObject();

    }

}
