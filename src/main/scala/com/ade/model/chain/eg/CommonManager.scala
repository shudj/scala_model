package com.ade.model.chain.eg

/**
 * 经理
 */
class CommonManager extends Manager {

    def this(name: String) = {
        this
        this.name = name
    }
    /**
     * 申请请求
     *
     * @param request
     */
    override def requestApplications(request: Request): Unit = {
        if (leave.equals(request.requestType) && request.number <= 2) {
            println(s"${this.name}:${request.requestContent} 天数 ${request.number} 被批准")
        } else if (null != superior) {
            superior.requestApplications(request)
        }
    }
}

/**
 * 总监
 */
class Majordomo extends Manager {

    def this(name: String) = {
        this
        this.name = name
    }
    /**
     * 申请请求
     *
     * @param request
     */
    override def requestApplications(request: Request): Unit = {
        if (leave.equals(request.requestType) && request.number <= 5) {
            println(s"${this.name}:${request.requestContent} 天数 ${request.number} 被批准")
        } else if (null != superior) {
            superior.requestApplications(request)
        }
    }
}

/**
 * 总经理
 */
class GeneralManager extends Manager {

    def this(name: String) = {
        this
        this.name = name
    }
    /**
     * 申请请求
     *
     * @param request
     */
    override def requestApplications(request: Request): Unit = {
        if (leave.equals(request.requestContent)) {
            println(s"${this.name}:${request.requestContent} 天数 ${request.number} 被批准")
        } else if (money.equals(request.requestType) && request.number <= 500) {
            println(s"${this.name}:${request.requestContent} 加薪 ${request.number} 元被批准")
        } else if (money.equals(request.requestType) && request.number > 500) {
            println(s"${this.name}:${request.requestContent} 数量过大 ${request.number} 再说吧")
        }
    }
}