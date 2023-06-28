package com.urise.webapp;

public class TestSingleton {
    public static TestSingleton outInstance = new TestSingleton();

    public static TestSingleton getInstance() {
        return outInstance;
    }

    private TestSingleton() {
    }
}
