package com.seckill.dao;

import org.apache.ibatis.annotations.Param;

import com.seckill.entity.SuccessSeckill;

public interface SuccessSeckillDao {
	/**
	 * 插入购买明细，可以过滤重复
	 * 
	 * @param seckill_id
	 * @param user_phone
	 * @return 如果大于0 插入数据成功
	 */
	int insertSuccessKilled(@Param("id") String id, @Param("seckill_id") String seckill_id,
			@Param("user_phone") String user_phone);

	/**
	 * 根據ID查詢秒殺成功信息並且攜帶秒殺商品信息
	 * 
	 * @param seckill_id
	 * @return
	 */
	SuccessSeckill getSuccessSeckill(@Param("seckill_id") String seckill_id, @Param("user_phone") String user_phone);

}
