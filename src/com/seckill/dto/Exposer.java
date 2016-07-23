package com.seckill.dto;

/**
 * 页面后台数据交互层 暴露秒杀地址
 * 
 * @author Nue
 *
 */
public class Exposer {
	// 是否开启秒杀
	private boolean exposed;
	private String md5;
	private String seckillId;
	private long now;
	private long start;
	private long end;

	public Exposer(boolean exposed, String md5, String seckillId) {
		this.exposed = exposed;
		this.md5 = md5;
		this.seckillId = seckillId;
	}

	public Exposer(boolean exposed, long now, long start, long end, String seckillId) {
		this.seckillId = seckillId;
		this.exposed = exposed;
		this.now = now;
		this.start = start;
		this.end = end;
	}

	public Exposer(boolean exposed, String seckillId) {
		this.exposed = exposed;
		this.seckillId = seckillId;
	}

	public boolean isExposed() {
		return exposed;
	}

	public void setExposed(boolean exposed) {
		this.exposed = exposed;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(String seckillId) {
		this.seckillId = seckillId;
	}

	public long getNow() {
		return now;
	}

	public void setNow(long now) {
		this.now = now;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Exposer [exposed=" + exposed + ", md5=" + md5 + ", seckillId=" + seckillId + ", now=" + now + ", start="
				+ start + ", end=" + end + "]";
	}

}
