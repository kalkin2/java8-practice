package com.java8.demo.modernJavaInAction.chapter11;

import java.util.Optional;

public class Person_Optional {

    private Optional<Car> car;

    //차가 없는 사람이 있을 수 있다.
    public Optional<Car> getCar() {
        return car;
    }


    private class Car {

        //보험이 없는 사람이 있을 수 있다.
        private Optional<Insurance> insurance;

        public Optional<Insurance> getInsurance() {
            return insurance;
        }
    }

    private class Insurance {
        private String name;

        private String getName() {
            return name;
        }
    }

}



