package com.ade.model.composite

/**
 * 组合模式（Composite），将对象组合成树形结构以表示“部分-整体”的层次结构，组合模式使得用户对单个对象和组合对象的使用具有一致性
 *
 * 透明模式：
 *    也就是说在Component中声明所有用来管理子对象的方法，其中包括Add、Remove等，这样实现Component接口的所有子类都具备了Add和Remove
 *    这样做的好处就是叶节点和枝节点对于外界没有区别，它们具备完全一致的行为接口，但问题也很明显，因为Leaf类本身不具备Add、Remove方法
 *    的功能，所以实现它是没有意义的
 *
 * 完全方式：
 *    也就是在Component接口中不去声明Add和Remove方法，那么子类的Leaf也就不需要去实现它，而是在Composite声明所有用来管理子类对象的
 *    方法，不过由于不够透明，所以树叶和树枝类将不具有相同的接口，客户端的调用需要做相应的判断，带来了不便
 *
 * 使用场景：
 *     需求中是体现部分与整体层次的结构时，以及你希望用户可以忽略组合对象与单个对象的不同，统一地使用组合结构中的所有对象时，就应该考虑
 *     组合模式了
 */
object TestComposite {

    def main(args: Array[String]): Unit = {
        val root = new Composite("root")
        root.add(new Leaf("Leaf A"))
        root.add(new Leaf("Leaf B"))

        val composite = new Composite("Composite X")
        composite.add(new Leaf("Leaf XA"))
        composite.add(new Leaf("Leaf XB"))

        root.add(composite)

        val composite1 = new Composite("Composite XY")
        composite1.add(new Leaf("Leaf XYA"))
        composite1.add(new Leaf("Leaf XYB"))
        composite.add(composite1)

        root.add(new Leaf("Leaf C"))
        val leaf = new Leaf("Leaf D")
        root.add(leaf)
        root.remove(leaf)

        root.display(1)
    }
}
