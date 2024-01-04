package com.zzz.pms.pmsgeneric.exception;

public enum ExceptionItemEnum implements ExceptionItem {
    SUCCESS("0x001", "成功"), ERROR("0x005", "失败"),
    VERIFYCODE_TIMEOUT("0x0041","验证码已经过期!"),
    VERIFYCODE_NO_FIND("0x0042","没有查到验证码!"),
    VALIDATE_FAILED("0x0043", "参数检验失败"),
    ;

    private final String code;
    private final String message;

    private ExceptionItemEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
