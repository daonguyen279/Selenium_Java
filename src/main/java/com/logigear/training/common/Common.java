package com.logigear.training.common;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

public class Common {
    public static final Faker faker = new Faker();

    public static Name randomName() {
        return faker.name();
    }
}
