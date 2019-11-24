package com.ade.model.chain.eg

object TestMoney {

    def main(args: Array[String]): Unit = {
        val commonManager = new CommonManager("经理")
        val majordomo = new Majordomo("总监")
        val generalManager = new GeneralManager("总经理")

        commonManager.setSuperior(majordomo)
        majordomo.setSuperior(generalManager)

        val request = new Request
        request.requestType = "请假"
        request.requestContent = "小菜请假"
        request.number = 1
        commonManager.requestApplications(request)

        val request1 = new Request
        request1.requestType = "请假"
        request1.requestContent = "小菜请假"
        request1.number = 4
        commonManager.requestApplications(request1)

        val request2 = new Request
        request2.requestType = "加薪"
        request2.requestContent = "小菜请求加薪"
        request2.number = 500
        commonManager.requestApplications(request2)

        val request3 = new Request
        request3.requestType = "加薪"
        request3.requestContent = "小菜请求加薪"
        request3.number = 1000
        commonManager.requestApplications(request3)
    }
}
