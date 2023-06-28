package com.urise.webapp;

public class TestSingleton {
    public static TestSingleton outInstance = new TestSingleton();

    public static TestSingleton getInstance() {
        return outInstance;
    }

    private TestSingleton() {
    }

    public static void main(String[] args) {
        TestSingleton.getInstance().toString();
        Singleton instance = Singleton.valueOf("INSTANCE");
        System.out.println(instance.ordinal());


    }

    public enum Singleton {
        INSTANCE
    }
}
