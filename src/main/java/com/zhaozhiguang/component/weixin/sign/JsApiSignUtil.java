package com.zhaozhiguang.component.weixin.sign;

import com.zhaozhiguang.component.weixin.pojo.res.JsSignResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.UUID;

/**
 * 微信JsApiTicket接口验证
 * @author zhiguang
 */
public class JsApiSignUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsApiSignUtil.class);

    public static JsSignResult sign(String jsapi_ticket, String url) {
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        StringBuilder string1 = new StringBuilder();
        String signature = "";
        //注意这里参数名必须全部小写，且必须有序
        string1.append("jsapi_ticket=").append(jsapi_ticket).append("&noncestr=").append(nonce_str).append("&timestamp=").append(timestamp).append("&url=").append(url);
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.toString().getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e) {
            logger.error("没有找到这样的算法", e);
        } catch (UnsupportedEncodingException e) {
            logger.error("不支持该编码类型", e);
        }
        return new JsSignResult(url, jsapi_ticket, nonce_str, timestamp, signature);
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

}
