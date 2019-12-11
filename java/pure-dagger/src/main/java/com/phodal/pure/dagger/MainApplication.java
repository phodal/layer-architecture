package com.phodal.pure.dagger;

import com.phodal.pure.dagger.domain.Car;

public class MainApplication {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.getEngine().hashCode());
    }
}
