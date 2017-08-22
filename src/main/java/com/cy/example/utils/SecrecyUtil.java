package com.cy.example.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class SecrecyUtil {
	
	/**
	 * DES算法密钥
	 */
	private static final byte[] DES_KEY = { 21, 1, -110, 82, -32, -85, -128, -65 };

	
	/**
	 * 对数据通过公钥进行加密，并进行base64计算
	 * 
	 * @param dataString
	 *            待处理数据
	 * @param encoding
	 *            字符编码
	 * @param key
	 *            公钥
	 * @return
	 */
	public static String encryptData(String dataString, String encoding,
			PublicKey key) {
		/** 使用公钥对密码加密 **/
		byte[] data = null;
		try {
			data = encryptData(key, dataString.getBytes(encoding));
			return new String(SecrecyUtil.base64Encode(data), encoding);
		} catch (Exception e) {
//			LogUtil.writeErrorLog(e.getMessage(), e);
			return "";
		}
	}

	/**
	 * 对数据通过公钥进行加密，并进行base64计算
	 * 
	 * @param dataString
	 *            待处理数据
	 * @param encoding
	 *            字符编码
	 * @param key
	 *            公钥
	 * @return
	 */
	public static String encryptPin(String accNo, String pin, String encoding,
			PublicKey key) {
		/** 使用公钥对密码加密 **/
		byte[] data = null;
		try {
			data = pin2PinBlockWithCardNO(pin, accNo);
			data = encryptData(key, data);
			return new String(SecrecyUtil.base64Encode(data), encoding);
		} catch (Exception e) {
//			LogUtil.writeErrorLog(e.getMessage(), e);
			return "";
		}
	}

	/**
	 * 通过私钥解密
	 * 
	 * @param dataString
	 *            base64过的数据
	 * @param encoding
	 *            编码
	 * @param key
	 *            私钥
	 * @return 解密后的数据
	 */
	public static String decryptData(String dataString, String encoding,
			PrivateKey key) {
		byte[] data = null;
		try {
			data = SecrecyUtil.base64Decode(dataString.getBytes(encoding));
			data = decryptData(key, data);
			return new String(data, encoding);
		} catch (Exception e) {
//			LogUtil.writeErrorLog(e.getMessage(), e);
			return "";
		}
	}

	/**
	 * BASE64解码
	 * 
	 * @param inputByte
	 *            待解码数据
	 * @return 解码后的数据
	 * @throws IOException
	 */
	public static byte[] base64Decode(byte[] inputByte) throws IOException {
		return Base64.decodeBase64(inputByte);
	}

	/**
	 * BASE64编码
	 * 
	 * @param inputByte
	 *            待编码数据
	 * @return 解码后的数据
	 * @throws IOException
	 */
	public static byte[] base64Encode(byte[] inputByte) throws IOException {
		return Base64.encodeBase64(inputByte);
	}

	/**
	 * 加密除pin之外的其他信息
	 * 
	 * @param publicKey
	 * @param plainData
	 * @return
	 * @throws Exception
	 */
	private static byte[] encryptData(PublicKey publicKey, byte[] plainData)
			throws Exception {
		try {
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			return cipher.doFinal(plainData);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * @param privateKey
	 * @param cryptPin
	 * @return
	 * @throws Exception
	 */
	private static byte[] decryptData(PrivateKey privateKey, byte[] data)
			throws Exception {
		try {
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			return cipher.doFinal(data);
		} catch (Exception e) {
//			LogUtil.writeErrorLog("解密失败", e);
		}
		return null;
	}

	/**
	 * 
	 * @param aPin
	 * @return
	 */
	private static byte[] pin2PinBlock(String aPin) {
		int tTemp = 1;
		int tPinLen = aPin.length();

		byte[] tByte = new byte[8];
		try {

			/*******************************************************************
			 * if (tPinLen > 9) { tByte[0] = (byte) Integer.parseInt(new
			 * Integer(tPinLen) .toString(), 16); } else { tByte[0] = (byte)
			 * Integer.parseInt(new Integer(tPinLen) .toString(), 10); }
			 ******************************************************************/
			// tByte[0] = (byte) Integer.parseInt(new
			// Integer(tPinLen).toString(),
			// 10);
			tByte[0] = (byte) Integer.parseInt(Integer.toString(tPinLen), 10);
			if (tPinLen % 2 == 0) {
				for (int i = 0; i < tPinLen;) {
					String a = aPin.substring(i, i + 2);
					tByte[tTemp] = (byte) Integer.parseInt(a, 16);
					if (i == (tPinLen - 2)) {
						if (tTemp < 7) {
							for (int x = (tTemp + 1); x < 8; x

							++) {
								tByte[x] = (byte) 0xff;
							}
						}
					}
					tTemp++;
					i = i + 2;
				}
			} else {
				for (int i = 0; i < tPinLen - 1;) {
					String a;
					a = aPin.substring(i, i + 2);
					tByte[tTemp] = (byte) Integer.parseInt(a, 16);
					if (i == (tPinLen - 3)) {
						String b = aPin.substring(tPinLen - 1) +

						"F";
						tByte[tTemp + 1] = (byte) Integer.parseInt

						(b, 16);
						if ((tTemp + 1) < 7) {
							for (int x = (tTemp + 2); x < 8; x

							++) {
								tByte[x] = (byte) 0xff;
							}
						}
					}
					tTemp++;
					i = i + 2;
				}
			}
		} catch (Exception e) {
		}

		return tByte;
	}

	/**
	 * 
	 * @param aPan
	 * @return
	 */
	private static byte[] formatPan(String aPan) {
		int tPanLen = aPan.length();
		byte[] tByte = new byte[8];
		;
		int temp = tPanLen - 13;
		try {
			tByte[0] = (byte) 0x00;
			tByte[1] = (byte) 0x00;
			for (int i = 2; i < 8; i++) {
				String a = aPan.substring(temp, temp + 2);
				tByte[i] = (byte) Integer.parseInt(a, 16);
				temp = temp + 2;
			}
		} catch (Exception e) {
		}
		return tByte;
	}

	/**
	 * 
	 * @param aPin
	 * @param aCardNO
	 * @return
	 */
	private static byte[] pin2PinBlockWithCardNO(String aPin, String aCardNO) {
		byte[] tPinByte = pin2PinBlock(aPin);
		if (aCardNO.length() == 11) {
			aCardNO = "00" + aCardNO;
		} else if (aCardNO.length() == 12) {
			aCardNO = "0" + aCardNO;
		}
		byte[] tPanByte = formatPan(aCardNO);
		byte[] tByte = new byte[8];
		for (int i = 0; i < 8; i++) {
			tByte[i] = (byte) (tPinByte[i] ^ tPanByte[i]);
		}
		return tByte;
	}

	
	/**
	 * 数据加密，算法（DES）
	 * 
	 * @param data
	 *            要进行加密的数据
	 * @return 加密后的数据
	 */
	@SuppressWarnings("restriction")
	public static String encryptBasedDes(String data) {
		String encryptedData = null;
		try {
			// DES算法要求有一个可信任的随机数源
			SecureRandom sr = new SecureRandom();
			DESKeySpec deskey = new DESKeySpec(DES_KEY);
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey key = keyFactory.generateSecret(deskey);
			// 加密对象
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key, sr);
			// 加密，并把字节数组编码成字符串
			encryptedData = new sun.misc.BASE64Encoder().encode(cipher.doFinal(data.getBytes()));
		} catch (Exception e) {
			// log.error("加密错误，错误信息：", e);
			throw new RuntimeException("加密错误，错误信息：", e);
		}
		return encryptedData;
	}

	/**
	 * 数据解密，算法（DES）
	 * 
	 * @param cryptData
	 *            加密数据
	 * @return 解密后的数据
	 */
	@SuppressWarnings("restriction")
	public static String decryptBasedDes(String cryptData) {
		String decryptedData = null;
		try {
			// DES算法要求有一个可信任的随机数源
			SecureRandom sr = new SecureRandom();
			DESKeySpec deskey = new DESKeySpec(DES_KEY);
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey key = keyFactory.generateSecret(deskey);
			// 解密对象
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key, sr);
			// 把字符串解码为字节数组，并解密
			decryptedData = new String(cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(cryptData)));
		} catch (Exception e) {
			// log.error("解密错误，错误信息：", e);
			throw new RuntimeException("解密错误，错误信息：", e);
		}
		return decryptedData;
	}
}
