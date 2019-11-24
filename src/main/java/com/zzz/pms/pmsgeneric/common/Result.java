package com.zzz.pms.pmsgeneric.common;

import com.zzz.pms.pmsgeneric.common.AppConst;

import java.util.Random;

public class Result<T> {

	private boolean success = true;

	private String code = AppConst.EXCEPTION_CODE + "1";

	private String msg = "成功";

	private T data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		if (!success) {
			if ("成功".equals(msg)) {
				setMsg("失败");
			}
		}
		Random r = new Random();
		int i = r.nextInt(10000);
		setCode(AppConst.EXCEPTION_CODE + i);
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result{" +
				"success=" + success +
				", code='" + code + '\'' +
				", msg='" + msg + '\'' +
				", data=" + data +
				'}';
	}
}
