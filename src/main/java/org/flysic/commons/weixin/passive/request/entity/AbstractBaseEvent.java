package org.flysic.commons.weixin.passive.request.entity;

/**
 * 基础POST事件实体类
 * @author 雪庭(flysic) QQ: 119238122 微信: flysic github: https://github.com/flysic
 * @sine at 2015年5月7日
 */
public abstract class AbstractBaseEvent extends AbstractBaseEntity {

	/** 事件类型 */
	private String Event;
	
	/**
	 * 取得事件类型
	 * @return 事件类型
	 */
	public String getEvent() {
		return Event;
	}
	
	/**
	 * 设置事件类型
	 * @param event 事件类型
	 */
	public void setEvent(String event) {
		Event = event;
	}
	
}
