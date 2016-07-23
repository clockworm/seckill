package com.seckill.dto;

import com.seckill.entity.SuccessSeckill;
import com.seckill.enums.SeckillStateEnum;

/**
 * 秒杀执行后结果
 * 
 * @author Nue
 *
 */
public class SeckillExecution {
	private String seckillId;
	private int state;
	private String stateInfo;
	private SuccessSeckill successSeckill;

	/**
	 * Success
	 * 
	 * @param seckillId
	 * @param state
	 * @param stateInfo
	 * @param successSeckill
	 */
	public SeckillExecution(String seckillId, SeckillStateEnum seckillStateEnum, SuccessSeckill successSeckill) {
		this.seckillId = seckillId;
		this.state = seckillStateEnum.getState();
		this.stateInfo = seckillStateEnum.getStateInfo();
		this.successSeckill = successSeckill;
	}

	/**
	 * fail
	 * 
	 * @param seckillId
	 * @param state
	 * @param stateInfo
	 */
	public SeckillExecution(String seckillId, SeckillStateEnum seckillStateEnum) {
		this.seckillId = seckillId;
		this.state = seckillStateEnum.getState();
		this.stateInfo = seckillStateEnum.getStateInfo();
	}

	public String getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(String seckillId) {
		this.seckillId = seckillId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public SuccessSeckill getSuccessSeckill() {
		return successSeckill;
	}

	public void setSuccessSeckill(SuccessSeckill successSeckill) {
		this.successSeckill = successSeckill;
	}

	@Override
	public String toString() {
		return "SeckillExecution [seckillId=" + seckillId + ", state=" + state + ", stateInfo=" + stateInfo
				+ ", successSeckill=" + successSeckill + "]";
	}

}
