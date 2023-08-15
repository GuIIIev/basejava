package com.urise.webapp;

public class LazySingleton {
    private static LazySingleton INSTANCE = new LazySingleton();

    private LazySingleton() {

    }

    private static class LazySingletonHolder {
        private static final LazySingleton INSTANCE = new LazySingleton();
    }

    public static LazySingleton getINSTANCE() {
        return LazySingletonHolder.INSTANCE;
    }
}
