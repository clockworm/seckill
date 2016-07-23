package com.seckill.test;

import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.seckill.dao.SuccessSeckillDao;
import com.seckill.entity.SuccessSeckill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-dao.xml" })
public class SuccessSeckillDaoTest {
	@Autowired
	private SuccessSeckillDao successSeckillDao;

	@Test
	public void testInsertSuccessKilled() {
		int insertSuccessKilled = successSeckillDao.insertSuccessKilled(UUID.randomUUID().toString(), "1005",
				"13036353072");
		System.out.println(insertSuccessKilled);
	}

	@Test
	public void testGetSuccessSeckill() {
		SuccessSeckill successSeckill = successSeckillDao.getSuccessSeckill("1005", "13036353072");
		System.out.println(successSeckill.getUserPhone() + successSeckill.getState());
		System.out.println(successSeckill.getSeckill());
	}

}
