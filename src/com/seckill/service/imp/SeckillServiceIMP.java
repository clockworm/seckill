package com.seckill.service.imp;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import com.seckill.dao.SeckillDao;
import com.seckill.dao.SuccessSeckillDao;
import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;
import com.seckill.entity.SuccessSeckill;
import com.seckill.enums.SeckillStateEnum;
import com.seckill.exception.RepeatSeckillException;
import com.seckill.exception.SeckillCloseException;
import com.seckill.exception.SeckillException;
import com.seckill.service.SeckillService;

@Service
public class SeckillServiceIMP implements SeckillService {
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private SeckillDao seckillDao;
	@Autowired
	private SuccessSeckillDao successSeckillDao;
	private final String salt = "dsfja 9wdi 9r32 4r590= 9-21";

	@Override
	public List<Seckill> getSeckLists() {
		return seckillDao.queryAll(0, 10);
	}

	@Override
	public Seckill getById(String seckillId) {
		return seckillDao.getSeckill(seckillId);
	}

	@Override
	public Exposer exportSeckillUrl(String seckillId) {
		Seckill seckill = getById(seckillId);
		if (seckill == null) {
			return new Exposer(false, seckillId);
		}
		Date startTime = seckill.getStartTime();
		Date endTime = seckill.getEndTime();
		Date nowTime = new Date();
		if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
			return new Exposer(false, nowTime.getTime(), startTime.getTime(), endTime.getTime(), seckillId);
		}
		String md5 = getMd5(seckillId);
		return new Exposer(true, md5, seckillId);
	}

	@Override
	@Transactional
	public SeckillExecution executeSeckill(String seckillId, String userPhone, String md5)
			throws SeckillException, RepeatSeckillException, SeckillCloseException {
		if (md5 == null || !md5.equals(getMd5(seckillId))) {
			throw new SeckillException("seckill data rewrite");
		}
		try {
			int reduceNumber = seckillDao.reduceNumber(seckillId, new Date());
			if (reduceNumber <= 0) {
				throw new SeckillCloseException("seckill closed");
			} else {
				int successKilled = successSeckillDao.insertSuccessKilled(UUID.randomUUID().toString(), seckillId,
						userPhone);
				if (successKilled <= 0) {
					throw new RepeatSeckillException("repeat seckill");
				} else {
					SuccessSeckill successSeckill = successSeckillDao.getSuccessSeckill(seckillId, userPhone);
					return new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, successSeckill);
				}
			}
		} catch (SeckillCloseException e1) {
			throw e1;
		} catch (RepeatSeckillException e2) {
			throw e2;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new SeckillCloseException("seckill inner error:" + e.getMessage());
		}
	}

	private String getMd5(String seckillId) {
		String md5 = seckillId + "/" + salt;
		return DigestUtils.md5DigestAsHex(md5.getBytes());
	}

}
