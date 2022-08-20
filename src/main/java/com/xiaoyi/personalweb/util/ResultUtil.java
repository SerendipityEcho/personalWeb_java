package com.xiaoyi.personalweb.util;

public class ResultUtil {

    private int code;
    private String message;
    private Object data;

    /**
     * 成功,只能是0
     */
    private static final int SUCCESS_CODE = 0;
    private static final String SUCCESS_MESSAGE = "操作成功";

    /**
     * 失败
     */
    private static final int FAIL_CODE = 1;
    private static final String FAIL_MESSAGE = "操作失败";


    public static ResultUtil success(Object data) {
        return new ResultUtil(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static ResultUtil success(String message, Object data) {
        return new ResultUtil(SUCCESS_CODE, message, data);
    }

    public static ResultUtil fail() {
        return new ResultUtil(FAIL_CODE, FAIL_MESSAGE, null);
    }

    public static ResultUtil fail(String message) {
        return new ResultUtil(FAIL_CODE, message, null);
    }

    public static ResultUtil fail(int code, String message) {
        return new ResultUtil(code, message, null);
    }

    private ResultUtil(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
