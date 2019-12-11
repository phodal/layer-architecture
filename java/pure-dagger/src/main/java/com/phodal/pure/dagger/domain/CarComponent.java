package com.phodal.pure.dagger.domain;

import dagger.Component;

@Component(modules = {CarModule.class})
public interface CarComponent {
    void inject(Car car);
}
