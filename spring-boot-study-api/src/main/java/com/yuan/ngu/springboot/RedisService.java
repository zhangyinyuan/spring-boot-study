package com.yuan.ngu.springboot;

public interface RedisService {

    /**
     * 根据指定key获取String
     * @param key
     * @return
     */
     String getStr(String key);

    /**
     * 设置Str缓存
     * @param key
     * @param val
     */
     void setStr(String key, String val);

    /**
     * 删除指定key
     * @param key
     */
     void del(String key);

    /**
     * 根据指定o获取Object
     * @param o
     * @return
     */
    public Object getObj(Object o);

    /**
     * 设置obj缓存
     * @param o1
     * @param o2
     */
     void setObj(Object o1, Object o2);

    /**
     * 删除Obj缓存
     * @param o
     */
     void delObj(Object o);

    Object opsForValue(String key);
}
