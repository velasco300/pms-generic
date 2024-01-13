package com.zzz.pms.generic.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AppException extends RuntimeException {

    private ExceptionItem exceptionItem;

    private AppException() {
        super();
    }

    private AppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    private AppException(String message, Throwable cause) {
        super(message, cause);
    }

    private AppException(String message) {
        super(message);
    }

    private AppException(Throwable cause) {
        super(cause);
    }

    public static AppException create(ExceptionItem exceptionItem) {
        AppException e = new AppException(exceptionItem.getMessage());
        e.setExceptionItem(exceptionItem);
        return e;
    }

    public static AppException create(ExceptionItem exceptionItem, Throwable cause) {
        AppException e = new AppException(exceptionItem.getMessage(), cause);
        e.setExceptionItem(exceptionItem);
        return e;
    }

    public static void throwException(ExceptionItem exceptionItem) {
        throw create(exceptionItem);
    }

}
