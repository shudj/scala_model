package com.ade.model.proxy

class Girl(name: String) {
    def getName = name
}

/**
 * 代理模式，就是被代理类和代理类都去实现同一个接口，
 * 应用场景：
 *     第一、远程代理，就是为一个对象在不同的地址空间提供局部代表，这样可以隐藏一个对象存在于不同地址空间的事实
 *     第二、虚拟代理，就是根据需要创建开销很大的对象，通过它来存放实例化需要很长时间的真实对象
 *     第三、安全代理，用来控制真实对象访问时的权限，一般用于对象应该有不同的访问权限的时候
 *     第四、智能指引，就是指当调用真实的对象时，代理处理另外一些事。如计算真实对象的引用次数，这样当该对象没有引用时，
 *           可以自动释放它；或当第一次引用一个持久对象时，将它装入内存；或在访问一个实际对象前，检查是否已经锁定它，
 *           以确保其他对象不能改变它
 */
object GirlMain {

    def main(args: Array[String]): Unit = {
        val girl = new Girl("wsq")
        val pi = new ProxyImpl(girl)
        pi.giveFlowers
        pi.giveDolls
    }
}
