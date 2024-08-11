package com.ppolivka.java;

public class SealedClasses {

    public static abstract sealed class Food permits Egg, Coke {

        abstract String name();

        public String action() {
            return "eating";
        }

    }

    public sealed interface Storage permits Egg, Coke {

        String store();

    }

    public static final class Egg extends Food implements Storage {
        @Override
        String name() {
            return "egg";
        }

        @Override
        public String store() {
            return "fridge";
        }
    }

    public static final class Coke extends Food implements Storage {
        @Override
        String name() {
            return "coke";
        }

        @Override
        public String action() {
            return "drinking";
        }

        @Override
        public String store() {
            return "bottle";
        }
    }

//    public static final class Cheese extends Food implements Storage {
//        @Override
//        String name() {
//            return "";
//        }
//
//        @Override
//        public String store() {
//            return "";
//        }
//    }

    static <T extends Food & Storage> void info(T item) {
        System.out.println(item.action() + " " + item.name() + " from " + item.store());
    }

    public static void main(String[] args) {
        info(new Egg());
        info(new Coke());
    }
}
