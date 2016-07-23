package com.seckill.test;

import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;
import com.seckill.exception.RepeatSeckillException;
import com.seckill.exception.SeckillCloseException;
import com.seckill.service.SeckillService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-dao.xml", "classpath:spring-service.xml" })
public class SeckillServiceTest {
	@Autowired
	private SeckillService seckillService;
	private final Logger logger = Logger.getLogger(this.getClass());

	@Test
	public void testGetSeckLists() {
		List<Seckill> list = seckillService.getSeckLists();
		logger.info("list=" + list);
	}

	@Test
	public void testGetById() {
		Seckill seckill = seckillService.getById("1001");
		logger.info("seckill=" + seckill);
	}

	@Test
	public void testExportSeckillUrl() {
		Exposer exposer = seckillService.exportSeckillUrl("1001");
		if (exposer.isExposed()) {
			logger.info("exposer" + exposer);
			try {
				SeckillExecution seckillExecution = seckillService.executeSeckill("1001", "18523976070",
						exposer.getMd5());
				logger.info("seckillExecution:" + seckillExecution);
			} catch (RepeatSeckillException e) {
				logger.error(e.getMessage());
			} catch (SeckillCloseException e1) {
				logger.error(e1.getMessage());
			}
		} else {
			logger.warn("exposer" + exposer);
		}
	}
}
