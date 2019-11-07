package com.ade.model.mould

trait Mould {

    def primitiveOperation1
    def primitiveOperation2
    def templateMethod: Unit = {
        primitiveOperation1
        primitiveOperation2
    }
}
