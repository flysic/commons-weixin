package org.flysic.commons.weixin.passive;

import org.flysic.commons.weixin.passive.PostProcessorAdapter;
import org.flysic.commons.weixin.passive.request.entity.EventMenuClickEntity;
import org.flysic.commons.weixin.passive.request.entity.TextEntity;
import org.flysic.commons.weixin.passive.request.entity.VideoEntity;
import org.flysic.commons.weixin.passive.response.entity.AbstractBaseResponse;
import org.flysic.commons.weixin.passive.response.entity.TextResponse;

/**
 * 测试用的POST处理器
 * @author 雪庭(flysic) QQ: 119238122 微信: flysic github: https://github.com/flysic
 * @sine 1.0 at 2015年5月8日
 */
public class MyPostProcessor extends PostProcessorAdapter {
	
	@Override
	public String postProcessText(TextEntity entity) {
		// 取得文本内容(花名)
		String flower = entity.getContent();
		// 花的介绍
		String flowerInfo;
		// 数据库查找
		flowerInfo = MyServiceImpl.findFlower(flower);
		// 以文本效应方式返回花的介绍
		TextResponse textResponse = this.responseManager.getTextResponse(entity);
		textResponse.setContent(flowerInfo);
		String result = this.responseManager.responseToXml(textResponse);
		return result;
	}

	@Override
	public String postProcessEventMenuClick(EventMenuClickEntity entity) {
		// 取得点击菜单的事件KEY值
		String eventKey = entity.getEventKey();
		AbstractBaseResponse response = null;
		String result;
		switch(eventKey) {
		case MyMessage.CLICK_TEXT:
			response = this.responseManager.getTextResponse(entity);
			// 可在这里进行处理
			break;
		case MyMessage.CLICK_IMAGE:
			response = this.responseManager.getImageResponse(entity);
			// 可在这里进行处理
			break;
		case MyMessage.CLICK_VOICE:
			response = this.responseManager.getVoiceResponse(entity);
			// 可在这里进行处理
			break;
		default:
			
		}
		result = this.responseManager.responseToXml(response);
		return result;
	}
	
	@Override
	public String postProcessVideo(VideoEntity entity) {
		TextResponse response = this.responseManager.getTextResponse(entity);
		return this.responseManager.responseToXml(response);
	}

}
