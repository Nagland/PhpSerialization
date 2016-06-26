/**
 * Project Name: PhpSerialization
 * Package cn.stackbox.phpserialize;
 * Date: 2016-06-16 17:54
 */
package cn.stackbox.phpserialize;

/**
 * ClassName: PhpSerializationException
 * Reason: SomeReason
 * Date: 2016-06-16 17:54
 *
 * @author SRK.Lyu (superalsrk@gmail.com)
 */
public class PhpSerializationException extends RuntimeException {

    public PhpSerializationException() {
        super();
    }

    public PhpSerializationException(String s) {
        super("OriginBody:" + s);
    }

}
