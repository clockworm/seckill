package com.seckill.exception;

/**
 * 重复秒杀异常
 * 
 * @author Nue
 *
 */
public class RepeatSeckillException extends SeckillException {
	private static final long serialVersionUID = 1L;

	public RepeatSeckillException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepeatSeckillException(String message) {
		super(message);
	}

}
