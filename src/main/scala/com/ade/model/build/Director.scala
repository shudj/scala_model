package com.ade.model.build

class Director {

    def construct(builder: Builder) = {
        builder.buildPartA
        builder.buildPartB
    }
}
