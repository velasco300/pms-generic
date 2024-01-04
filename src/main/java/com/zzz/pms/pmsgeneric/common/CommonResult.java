package com.zzz.pms.pmsgeneric.common;

import com.zzz.pms.pmsgeneric.exception.ExceptionItem;
import com.zzz.pms.pmsgeneric.exception.ExceptionItemEnum;
import lombok.Data;

@Data
public class CommonResult<T> {
    private boolean success;
    private String traceId;
    private String code;
    private String message;
    private T data;

    private CommonResult() {
    }

    private CommonResult(boolean success, String traceId, String code, String message, T data) {
        this.success = success;
        this.traceId = traceId;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(true, String.valueOf(System.currentTimeMillis()), ExceptionItemEnum.SUCCESS.getCode(), ExceptionItemEnum.SUCCESS.getMessage(), data);
    }

    public static <T> CommonResult<T> error(T data) {
        return new CommonResult<T>(false, String.valueOf(System.currentTimeMillis()), ExceptionItemEnum.ERROR.getCode(), ExceptionItemEnum.ERROR.getMessage(), data);
    }

    public static CommonResult<String> error(ExceptionItem exceptionItem) {
        return failed("", exceptionItem);
    }

    public static CommonResult<String> failed(String traceId, ExceptionItem exceptionItem) {
        return new CommonResult<String>(false, traceId, exceptionItem.getCode(), exceptionItem.getMessage(), "");
    }

    public static <T> CommonResult<T> failed(String traceId, ExceptionItem exceptionItem, T data) {
        return new CommonResult<T>(false, traceId, exceptionItem.getCode(), exceptionItem.getMessage(), data);
    }


    @Override
    public String toString() {
        return "CommonResult{" + "success=" + success + ", code='" + code + '\'' + ", message='" + message + '\'' + ", data=" + data + '}';
    }
}
