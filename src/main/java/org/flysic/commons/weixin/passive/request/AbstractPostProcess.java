package org.flysic.commons.weixin.passive.request;

import org.flysic.commons.weixin.passive.request.entity.AbstractBaseEntity;
import org.springframework.util.Assert;

/**
 * POST方式推送给微信公众账号的消息处理，定义处理逻辑。
 * @author 雪庭(flysic) QQ: 119238122 微信: flysic github: https://github.com/flysic
 * @since 1.0 at 2015年4月3日
 */
public abstract class AbstractPostProcess implements IPostProcess {
	
	public String process(String postData) {
		Assert.hasText(postData, "postData 参数不能为空");
		// 消息解析为实体
		AbstractBaseEntity entity = analyze(postData);
		// 处理实体
		String resData = process(entity);
		// 返回响应信息
		return resData;
	}
	
	/**
	 * 消息解析为实体
	 * @param postData POST方式推送的数据
	 * @return 解析后的实体
	 */
	abstract AbstractBaseEntity analyze(String postData);

	/**
	 * 处理实体
	 * @param entity 实体，包含类型和对象
	 * @return 响应信息
	 */
	abstract String process(AbstractBaseEntity entity); 

}
