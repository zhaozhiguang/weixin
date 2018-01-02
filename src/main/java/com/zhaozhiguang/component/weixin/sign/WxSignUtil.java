package com.zhaozhiguang.component.weixin.sign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 微信接口验证
 *
 * 微信验证接口,如果验证成功返回true,否则返回false
 * true的情况下原样返回随机字符串给微信
 *
 * @author zhiguang
 */
public class WxSignUtil {

    private static final Logger logger = LoggerFactory.getLogger(WxSignUtil.class);

    /**
     * 验证签名
     * @param token
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkSignature(String token, String signature, String timestamp, String nonce){
        String[] arr = new String[]{token, timestamp, nonce};
        Arrays.sort(arr);// 将 token, timestamp, nonce 三个参数进行字典排序
        StringBuilder content = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            content.append(arr[i]);
        }
        String tmpStr = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");// 将三个参数字符串拼接成一个字符串进行 shal 加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            logger.error("微信接口验证发生错误", e);
        }
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    /**
     * 将字节数组转换为十六进制字符串
     * @param digest
     * @return
     */
    private static String byteToStr(byte[] digest) {
        StringBuilder strDigest = new StringBuilder();
        for(int i = 0; i < digest.length; i++){
            strDigest.append(byteToHexStr(digest[i]));
        }
        return strDigest.toString();
    }

    /**
     * 将字节转换为十六进制字符串
     * @param b
     * @return
     */
    private static String byteToHexStr(byte b) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(b >>> 4) & 0X0F];
        tempArr[1] = Digit[b & 0X0F];
        return new String(tempArr);
    }
}
