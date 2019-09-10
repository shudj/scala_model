package com.ade.concurrent.code.instance;

/**
 * @author: shudj
 * @time: 2019/9/10 17:32
 * @description: 基于volatile的延迟初始化方案：用于对实例字段使用线程安全的延迟初始化
 */
public class SafeDoubleCheckedLocking_java {
    private volatile static Instance instance;

    public Instance getInstance() {
        if (null == instance) {
            synchronized (SafeDoubleCheckedLocking_java.class) {
                if (null == instance) {
                    instance = new Instance();
                }
            }
        }

        return instance;
    }

}
