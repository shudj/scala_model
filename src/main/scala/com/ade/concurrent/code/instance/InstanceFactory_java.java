package com.ade.concurrent.code.instance;

/**
 * @author: shudj
 * @time: 2019/9/10 17:26
 * @description: 基于类的初始化方案：用于对静态字段使用线程安全的延迟初始化
 */
public class InstanceFactory_java {
    private static class InstanceHolder {
        public static Instance instance = new Instance();
    }

    public static Instance getInstance() {
        // 这将导致InstanceHolder类被初始化
        return InstanceHolder.instance;
    }
}
