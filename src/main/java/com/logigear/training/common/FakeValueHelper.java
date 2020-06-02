package com.logigear.training.common;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class FakeValueHelper {

    static FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
    static Faker faker = new Faker();

    public static FakeValuesService getFakeValuesService() {
        return fakeValuesService;
    }

    public static Faker getFaker() {
        return faker;
    }
}
