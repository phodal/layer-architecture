package com.phodal.pure.dagger.domain;

import javax.inject.Inject;

public class Car {
    @Inject
    Engine engine;

    public Car() {
        DaggerCarComponent.builder().build().inject(this);
    }

    public Engine getEngine() {
        return this.engine;
    }
}
