package com.gpl.util;

import java.io.Serializable;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 * Created by gpl on 2016/7/14.
 */
public class Encrypt {
    private final String key = "!!L[pKjBTal`A?G%!!L[pKjBTal`A?G1";
    private final String algorithm = "AES/CBC/PKCS5Padding";
    private final String encode = "utf-8";
    private final String iv = "0000000000000000";

    private String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    private byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
                    16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    private String aesEncrypt(String param) {
        String result = "";
        try {
            SecretKeySpec key = new SecretKeySpec(
                    this.key.getBytes(this.encode), "AES");
            IvParameterSpec iv = new IvParameterSpec(this.iv.getBytes());
            Cipher cipher = Cipher.getInstance(this.algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);

            byte[] byteContent = param.getBytes(this.encode);
            byte[] cipherByte = cipher.doFinal(byteContent);
            result = this.parseByte2HexStr(cipherByte);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

    private String aesDecrypt(String param) {
        String result = "";
        try {
            SecretKeySpec key = new SecretKeySpec(
                    this.key.getBytes(this.encode), "AES");
            IvParameterSpec iv = new IvParameterSpec(this.iv.getBytes());
            Cipher cipher = Cipher.getInstance(this.algorithm);
            cipher.init(Cipher.DECRYPT_MODE, key, iv);

            byte[] plainByte = cipher.doFinal(this.parseHexStr2Byte(param));
            result = new String(plainByte, this.encode);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

    public String encrypt(String params){
        String enText = this.aesEncrypt(params);
        try {
            return new String(Base64.encodeBase64(enText.getBytes(this.encode)),this.encode);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    public String decrypt(String params){
        String result = "";
        try {
            params = new String(Base64.decodeBase64(params.getBytes(this.encode)),this.encode);
            result = this.aesDecrypt(params);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
