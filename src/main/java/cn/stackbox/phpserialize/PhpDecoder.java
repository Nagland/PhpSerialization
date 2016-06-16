/**
 * Project Name: PhpSerialization
 * Package cn.stackbox.phpserialize;
 * Date: 2016-06-16 16:35
 */
package cn.stackbox.phpserialize;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: PhpPersister <br/>
 * Reason: SomeReason <br/>
 * Date: 2016-06-16 16:35
 *
 * @author SRK.Lyu (superalsrk@gmail.com)
 */
public class PhpDecoder {

    /**
     * PHP Serialize String Pattern
     */
    private static Pattern PATTERN_TOKEN_STRING = Pattern.compile("^s:(\\d+):\"([\\s\\S]+)\";$");

    /**
     * PHP Serialize Array(Map) Pattern
     */
    private static Pattern PATTERN_TOKEN_ARRAY = Pattern.compile("^a:(\\d+):;$");

    /**
     * PHP Serialize object split delimeter
     */
    private static String TOKEN_SPLIT_DELIMETER = "{};";

    /**
     * Deocded origin string body
     */
    private String persistBody;

    /**
     * Decoded tokens iterator
     */
    private StringTokenizer decodeTokens;

    private PhpDecoder(String persistBody) {
        this.persistBody = persistBody;
        decodeTokens = new StringTokenizer(persistBody, TOKEN_SPLIT_DELIMETER);
    }

    public static PhpDecoder newInstance(String persistBody) {
        return new PhpDecoder(persistBody);
    }



    public JSONArray decode() {
//        while (decodeTokens.hasMoreTokens()) {
//            System.out.println(decodeTokens.nextToken() + ";");
//        }

        JSONArray retArray = new JSONArray();


        while (decodeTokens.hasMoreTokens()) {

            String tokenString = decodeTokens.nextToken() + ";";

            String tokenMeta = tokenString.substring(0, 2);

            if(tokenMeta.equals("s:")) {
                retArray.add(parseString(tokenString));
            }
            else if(tokenMeta.equals("a:")) {
                retArray.add(parseObject(tokenString));
            }
            else {
                retArray.add(tokenString);
            }
        }

        return retArray;
    }



    private String parseString(String tokenString) {
        return PhpDecoder.unserializeString(tokenString);
    }


    private JSONObject parseObject(String tokenString) {

        JSONObject ret = new JSONObject();
        Integer size = PhpDecoder.unserializeArray(tokenString);

        for(int i = 0; i < size; i++) {

            if((!decodeTokens.hasMoreTokens()) && (i < size - 2)) {
                throw new PhpSerializationException(this.persistBody);
            }

            String mapKey = PhpDecoder.unserializeString(decodeTokens.nextToken() + ";");

            String mapValueContent = decodeTokens.nextToken() + ";";

            if(mapValueContent.startsWith("a:")) {
                ret.put(mapKey, parseObject(mapValueContent));
            }
            else if(mapValueContent.startsWith("s:")) {
                ret.put(mapKey, PhpDecoder.unserializeString(mapValueContent));
            } else {
                ret.put(mapKey, mapValueContent);
            }
        }
        return ret;
    }



    public static String unserializeString(String serializedString) {

        Matcher matcher = PATTERN_TOKEN_STRING.matcher(serializedString);
        if(matcher.matches() && matcher.groupCount() == 2) {
            return matcher.group(2);
        } else {
            return null;
        }
    }


    public static Integer unserializeArray(String serializeString) {
        Matcher matcher = PATTERN_TOKEN_ARRAY.matcher(serializeString);

        if(matcher.matches() && matcher.groupCount() == 1) {
            return Integer.parseInt(matcher.group(1));
        } else {
            return 0;
        }
    }

}
