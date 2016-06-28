package cn.stackbox.phpserialize;

import com.alibaba.fastjson.JSONArray;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Unit test for PhpDecoder
 */
public class PhpDecoderTest {

    @Test
    public void testSerializer1() {
        String body = "a:2:{s:6:\"_token\";s:40:\"nLOlgJE3e1IwP8WimS4k44vMc8NVIC08N159pju4\";s:9:\"_previous\";s:29:\"http://example.com/test/home/index\";";

        PhpDecoder decoder = PhpDecoder.newInstance(body);
        decoder.decode();
    }

    @Test
    public void testSerializer2() {
        String body = "a:7:{s:6:\"_token\";s:40:\"nLOlgJE3e1IwP8WimS4k44vMc8NVIC08N159pju4\";s:9:\"_previous\";a:1:{s:3:\"url\";s:29:\"http://example.com/test/home/index\";}s:5:\"flash\";a:2:{s:3:\"old\";a:0:{}s:3:\"new\";a:0:{}}s:9:\"auth_code\";s:32:\"9cee7bcf269a8edf5f313595eef919ce\";s:3:\"url\";a:1:{s:8:\"intended\";s:29:\"http://example.com/test/home/index\";}s:50:\"login_web_59ba36addc2b2f9401580f014c7f58ea4e30989d\";s:32:\"4d4eb6317e5e4871897fdd7165964d3a\";s:9:\"_sf2_meta\";a:3:{s:1:\"u\";i:1466043199;s:1:\"c\";i:1466042852;s:1:\"l\";s:1:\"0\";}}";

        PhpDecoder decoder = PhpDecoder.newInstance(body);
        JSONArray ret = decoder.decode();

        System.out.println(ret.toJSONString());

    }

    @Test
    public void testSerializer3() {
        String body = "s:392:\"a:6:{s:6:\"_token\";s:40:\"nLOlgJE3e1IwP8WimS4k44vMc8NVIC08N159pju4\";s:9:\"_previous\";a:1:{s:3:\"url\";s:31:\"http://example.com/test/login-direct\";}s:5:\"flash\";a:2:{s:3:\"old\";a:0:{}s:3:\"new\";a:0:{}}s:9:\"auth_code\";s:32:\"9cee7bcf269a8edf5f313595eef919ce\";s:3:\"url\";a:1:{s:8:\"intended\";s:29:\"http://example.com/test/home/index\";}s:9:\"_sf2_meta\";a:3:{s:1:\"u\";i:1466043462;s:1:\"c\";i:1466042852;s:1:\"l\";s:1:\"0\";}}\";";
    }

    @Test
    public void testSerializer4() {
        String body = "s:392:\"a:6:{s:6:\"_token\";s:40:\"nLOlgJE3e1IwP8WimS4k44vMc8NVIC08N159pju4\";s:9:\"_previous\";a:1:{s:3:\"url\";s:31:\"http://example.com/test/login-direct\";}s:5:\"flash\";a:2:{s:3:\"old\";a:0:{}s:3:\"new\";a:0:{}}s:9:\"auth_code\";s:32:\"9cee7bcf269a8edf5f313595eef919ce\";s:3:\"url\";a:1:{s:8:\"intended\";s:29:\"http://example.com/test/home/index\";}s:9:\"_sf2_meta\";a:3:{s:1:\"u\";i:1466043462;s:1:\"c\";i:1466042852;s:1:\"l\";s:1:\"0\";}}\";";

        String parsedBody = PhpDecoder.unserializeString(body);
        System.out.println(parsedBody);
    }

    @Test
    public void testSerialize5() {
        String body = "a:6:;";
        System.out.println(PhpDecoder.unserializeArray(body));
    }

    @Test
    public void testStringArray() {
        String body = "s:6:\"_token\";s:40:\"nLOlgJE3e1IwP8WimS4k44vMc8NVIC08N159pju4\";";
        PhpDecoder decoder = PhpDecoder.newInstance(body);
        System.out.println(decoder.decode().toJSONString());
    }
}
