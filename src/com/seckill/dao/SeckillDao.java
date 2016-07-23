package com.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seckill.entity.Seckill;

public interface SeckillDao {

	/**
	 * 减库存
	 * 
	 * @param seckill_id
	 * @param killTime
	 * @return 如果大于0 减库存成功
	 */
	int reduceNumber(@Param("seckill_id") String seckill_id,@Param("killTime") Date killTime);

	/**
	 * 通过ID得到秒杀商品
	 * 
	 * @param seckill_id
	 * @return
	 */
	Seckill getSeckill(String seckill_id);

	/**
	 * 根据偏移量得到部分秒杀商品
	 * 
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Seckill> queryAll(@Param("offset") int offset,@Param("size") int size);

}