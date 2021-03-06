package org.flysic.commons.weixin.passive.request;

import org.springframework.util.Assert;

import com.qq.weixin.mp.aes.AesException;

/**
 * POST方式推送给微信公众账号的加密消息处理，定义加密解密处理逻辑。
 * @author 雪庭(flysic) QQ: 119238122 微信: flysic github: https://github.com/flysic
 * @sine 1.0 at 2015年4月3日
 */
public abstract class AbstractEncyptPostProcess extends DefaultPostProcess implements IEncyptPostProcess {

	@Override
	public String process(String signature, String timeStamp, String nonce, String postData) throws AesException {
		Assert.hasText(signature);
		Assert.hasText(timeStamp);
		Assert.hasText(postData);
		// 解密消息
		String decyptData = decypt(signature, timeStamp, nonce, postData);
		// 处理消息
		String responseData = process(decyptData);
		// 加密处理响应信息
		String encryptionData = encryption(responseData, timeStamp, nonce);
		// 返回处理响应信息
		return encryptionData;
	}

	/**
	 * 解密消息
	 * @param signature 微信加密签名
	 * @param timestamp 时间戳 
	 * @param nonce 随机数
	 * @param postData POST方式推送的加密数据
	 * @return 解密后的消息
	 * @throws AesException 解密异常
	 */
	protected abstract String decypt(String signature, String timeStamp, String nonce,	String postData) throws AesException; 
	
	/**
	 * 加密消息
	 * @param responseData 响应消息 
	 * @param timeStamp 时间戳
	 * @param nonce 随机数
	 * @return 加密后的消息
	 * @throws AesException 加密异常
	 */
	protected abstract String encryption(String responseData, String timeStamp, String nonce) throws AesException;
	

}
