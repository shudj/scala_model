package com.ade.model.mould

/**
 * 模板方法模式是通过把不变形为搬移到超类，去除子类中的重复代码来体现它的优势
 * 当不变的和可变的行为在方法的子类实现中混合在一起的时候，不变的行为就会在子类中重复出现，我们通过模板方法模式把这些行为
 * 搬移到单一的地方，这样就帮助子类摆脱重复的不变行为的纠缠
 */
object TestMould {

    def main(args: Array[String]): Unit = {
        val classA = new ConcreteClassA
        classA.templateMethod
        val classB = new ConcreteClassB
        classB.templateMethod
    }
}
