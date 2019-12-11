package com.phodal.pure.dagger.domain;

import javax.inject.Inject;

public class Engine {
    @Inject
    Engine(){}

    public void run(){
        System.out.println("引擎转起来了~~~");
    }
}
