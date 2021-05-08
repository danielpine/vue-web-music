package com.example.demo.utils;

import com.example.demo.bo.Result;

public class ResultUtil {
    public static <T> Result<T> success(T data, String msg) {
        return msg(1, msg, data);
    }

    public static <T> Result<T> success(T data) {
        return success(data, "成功");
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> error(Integer code, String msg) {
        return msg(code, msg);
    }

    public static <T> Result<T> error(String msg) {
        return msg(0, msg);
    }

    public static <T> Result<T> msg(Integer code, String msg) {
        return msg(code, msg, null);
    }

    public static <T> Result<T> msg(Integer code, String msg, T data) {
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

}
