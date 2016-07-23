package com.seckill.service;

import java.util.List;
import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;
import com.seckill.exception.RepeatSeckillException;
import com.seckill.exception.SeckillCloseException;
import com.seckill.exception.SeckillException;

/**
 * 秒杀业务逻辑接口
 * @author Nue
 *
 */
public interface SeckillService {
	
	/**
	 * 秒杀列表
	 * @return
	 */
	List<Seckill> getSeckLists();

	/**
	 * 秒杀对象
	 * @param seckillId
	 * @return
	 */
	Seckill getById(String seckillId);

	/**
	 * 秒杀地址，或者倒计时或者秒杀时间
	 * @param seckillId
	 * @return
	 */
	Exposer exportSeckillUrl(String seckillId);

	/**
	 * 执行秒杀操作 可能有出现异常
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	SeckillExecution executeSeckill(String seckillId, String userPhone, String md5)
			throws SeckillException, RepeatSeckillException, SeckillCloseException;
}
