package com.ade.model.factory.leifeng

trait IFactory {
    def createLeiFeng: LeiFeng
}

class UndergraduateFactory extends IFactory {
    override def createLeiFeng: LeiFeng = new Undergraduate
}

class VolunteerFactory extends IFactory {
    override def createLeiFeng: LeiFeng = new Volunteer
}