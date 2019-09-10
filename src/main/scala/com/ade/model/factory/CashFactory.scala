package com.ade.model.factory

/**
 * 商城收费的简单工厂模式
 * 1.正常收费
 * 2.打折处理
 * 3.满减
 */

trait CashSuper {
    def acceptCash(money: Double): Double
}

// 正常收费
class CashNormal extends CashSuper {
    override def acceptCash(money: Double): Double = {
        money
    }
}

// 打折处理
class CashRebate extends CashSuper {
    private[this] var moneyRebate: Double = 0.0D

    def this(moneyRebate: String) {
        this()
        this.moneyRebate = moneyRebate.toDouble
    }

    override def acceptCash(money: Double): Double = {
        money * this.moneyRebate
    }
}

class CashReturn extends CashSuper {
    private[this] var moneyCondition = 0.0D
    private[this] var moneyReturn = 0.0D

    def this(moneyCondition: String, moneyReturn: String) {
        this
        this.moneyCondition = moneyCondition.toDouble
        this.moneyReturn = moneyReturn.toDouble
    }

    override def acceptCash(money: Double): Double = {
        var result = money

        if (money >= moneyCondition) {
            result = money - Math.floor(money / this.moneyCondition) * moneyReturn
        }
        result
    }
}

object CashFactory {

    def createCashAccept(type_1: String): CashSuper = {
        val cs: CashSuper = type_1 match {
            case "正常收费" => new CashNormal
            case "满300返100" => new CashReturn("300", "100")
            case "打8折" => new CashRebate("0.8")
            case _ => null
        }
        cs
    }


}
