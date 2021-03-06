package org.flysic.commons.weixin.passive.request;

import com.qq.weixin.mp.aes.AesException;

/**
 * POST方式推送给微信公众账号的加密消息处理， 使用AES对称加密算法。
 * 针对推送给微信公众账号的普通消息和事件消息，以及推送给设备公众账号
 * 的设备消息进行加密，公众账号对密文消息的回复也要求加密。
 * @author 雪庭(flysic) QQ: 119238122 微信: flysic github: https://github.com/flysic
 * @since 1.0 at 2015年4月3日
 */
public interface IEncyptPostProcess extends IPostProcess {
	
	/**
	 * 处理加密消息
	 * @param signature 微信加密签名
	 * @param timestamp 时间戳
	 * @param nonce 随机数
	 * @param postData POST方式推送的加密数据
	 * @return 处理响应信息
	 * @throws AesException 解密异常
	 */
	String process(String signature, String timeStamp, String nonce, String postData) throws AesException;
	
}
