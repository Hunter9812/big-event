package com.example.entity;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import org.slf4j.MDC;

import java.util.Optional;

/**
 * 响应实体类封装，Rest风格
 * @param code 状态码
 * @param data 响应数据
 * @param message 其他消息
 * @param <T> 响应数据类型
 */
public record RestBean<T> (long id, int code, T data, String message) {
    public static <T> RestBean<T> success(T data){
        // 200 OK 请求成功。一般用于GET与POST请求
        return new RestBean<>(requestId(), 200, data, "请求成功");
    }

    public static <T> RestBean<T> success(){
        return success(null);
    }

    public static <T> RestBean<T> forbidden(String message){
        // 403 Forbidden 服务器理解请求客户端的请求，但是拒绝执行此请求
        return failure(403, message);
    }

    public static <T> RestBean<T> unauthorized(String message){
        // 401 Unauthorized 请求要求用户的身份认证
        // 虽然 HTTP 标准指定了"unauthorized"，但从语义上来说，这个响应意味着"unauthenticated"(未经认证的)。
        return failure(401, message);
    }

    public static <T> RestBean<T> failure(int code, String message){
        return new RestBean<>(requestId(), code, null, message);
    }

    /**
     * 快速将当前实体转换为JSON字符串格式
     * @return JSON字符串
     */
    public String asJsonString() {
        // 第二个参数会将所有属性添加到json字符串中，不加只包含非null值的属性
        return JSONObject.toJSONString(this, JSONWriter.Feature.WriteNulls);
    }

    /**
     * 获取当前请求ID方便快速定位错误
     * @return ID
     */
    private static long requestId(){
        // MDC（Mapped Diagnostic Context）是一个线程本地的上下文环境，可以存储和访问线程相关的附加信息。
        // 获取名为 "reqId" 的 MDC 值，并使用 Optional.ofNullable() 方法将其包装成一个 Optional 对象
        String requestId = Optional.ofNullable(MDC.get("reqId")).orElse("0");
        return Long.parseLong(requestId);
    }
}
