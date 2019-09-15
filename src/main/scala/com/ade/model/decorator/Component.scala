package com.ade.model.decorator

/**
 * 装饰模式，动态地给一个对象添加一些额外的职责，就增加功能来说，装饰模式比生成子类更为灵活
 *
 * 装饰模式是为已有功能动态地添加更多功能的一种方式
 * 当系统需要新功能的时候，向旧的类中添加新的代码，这些新加的代码通常装饰了原有类的核心职责或主要行为
 *
 * 优点：
 *     把类中的装饰功能从类中搬移去除，这样可以简化原有的类
 *     有效地把类的核心职责和装饰功能区分开了，而且可以去除相关类中重复的装饰逻辑
 */
trait Component {

    def operation()
}
