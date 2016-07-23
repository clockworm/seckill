package com.seckill.entity;

import java.util.Date;

/**
 * 秒杀成功明细
 * 
 * @author Nue
 */
public class SuccessSeckill {
	private String id;
	private String seckillId;
	private String userPhone;
	private int state;
	private Date createTime;
	private Seckill seckill;

	public Seckill getSeckill() {
		return seckill;
	}

	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(String seckillId) {
		this.seckillId = seckillId;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
