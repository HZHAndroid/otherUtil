package com.hzh.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author juniu
 * @date 18/5/17
 * @description 对象复制工具类
 */

public class CopyUtil {
    /**
     * 深层拷贝(有缺陷，有泛型的集合无法完全复制，有些对象无法正常转型)
     *
     * @param obj       需要拷贝的对象
     * @param classType 被拷贝对象的类型
     * @return 深拷贝的对象
     */
    @Deprecated
    private static <T> T cloneBean(Object obj, Class<T> classType) {
        if (obj == null) {
            return null;
        }
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        return gson.fromJson(json, classType);
    }

    /**
     * 克隆对象
     *
     * @param obj       需要克隆的对象
     * @param typeToken 克隆返回的的结果类型的辅助类(T是返回结果)
     * @param <T>       返回结果
     * @return
     */
    public static <T> T cloneBean(Object obj,
                                  TypeToken<T> typeToken) {
        if (obj == null) {
            return null;
        }
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        return gson.fromJson(json, typeToken.getType());
    }
}
