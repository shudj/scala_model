package com.ade.model.chain.eg

/**
 * 管理者
 */
abstract class Manager {

    protected val leave: String = "请假"
    protected val money: String = "加薪"
    protected var name: String = _
    // 管理者的上级
    protected var superior: Manager = _
    def this(name: String) = {
        this
        this.name = name
    }

    /**
     * 设置管理者的上级
     * @param superior  管理者上级
     */
    def setSuperior(superior: Manager) = this.superior = superior

    /**
     * 申请请求
     * @param request
     */
    def requestApplications(request: Request)
}
