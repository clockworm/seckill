package com.seckill.test;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.seckill.dao.SeckillDao;
import com.seckill.entity.Seckill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-dao.xml" })
public class SeckillDaoTest {
	@Autowired
	private SeckillDao seckillDao;

	@Test
	public void testReduceNumber() {
		int reduceNumber = seckillDao.reduceNumber("1001",new Date());
		System.out.println(reduceNumber);
	}

	@Test
	public void testGetSeckill() {
		Seckill seckill = seckillDao.getSeckill("1001");
		System.out.println(seckill);
	}

	@Test
	public void testQueryAll() {
		List<Seckill> list = seckillDao.queryAll(0, 100);
		for (Seckill seckill : list) {
			System.out.println(seckill);
		}
	}

}
