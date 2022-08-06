package com.xiaoyi.personalweb.entity;

public class Result {
    public static Result getSuccessResult(Object data, String message)
    {
        return new Result(data, message, true);
    }

    public static Result getFailedResult(Object data, String message)
    {
        return new Result(data, message, false);
    }

    public static Result getSuccessResult(Object data)
    {
        return new Result(data, "操作成功！", true);
    }

    public static Result getFailedResult(Object data)
    {
        return new Result(data, "操作失败", false);
    }

    public Result(Object data, String message, boolean isSuccess)
    {
        this.data = data;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public Result(Object data, boolean isSuccess)
    {
        this.data = data;
        this.isSuccess = isSuccess;

        if(isSuccess)
        {
            this.message = "操作成功！";
        }
        else
        {
            this.message = "操作失败！";
        }
    }

    public Result(boolean isSuccess)
    {
        this.isSuccess = isSuccess;

        if(isSuccess)
        {
            this.message = "操作成功！";
        }
        else
        {
            this.message = "操作失败！";
        }
    }

    private Object data;
    private String message;
    private boolean isSuccess;
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public boolean isSuccess() {
        return isSuccess;
    }
    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
