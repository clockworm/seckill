package com.seckill.exception;

/**
 * 秒杀通用异常
 * 
 * @author Nue
 *
 */
public class SeckillException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SeckillException(String message, Throwable cause) {
		super(message, cause);
	}

	public SeckillException(String message) {
		super(message);
	}

}
