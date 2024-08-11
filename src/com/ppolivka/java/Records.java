package com.ppolivka.java;

import java.util.Objects;

public class Records {

    public static void main(String[] args) {

        Pet dog = new Pet("Alik", "Dog");
        Pet dog2 = new Pet("Maxipes", "Dog");
        Pet dog3 = new Pet("Alik", "Dog");

        System.out.println(dog + " is " + (dog.equals(dog2) ? "same" : "different") + " as " + dog2);
        System.out.println(dog + " is " + (dog.equals(dog3) ? "same" : "different") + " as " + dog3);


        Pet2 cat = new Pet2("Micka", "Cat");
        Pet2 cat2 = new Pet2("Mačka", "Cat");
        Pet2 cat3 = new Pet2("Micka", "Cat");

        System.out.println(cat + " is " + (cat.equals(cat2) ? "same" : "different") + " as " + cat2);
        System.out.println(cat + " is " + (cat.equals(cat3) ? "same" : "different") + " as " + cat3);
    }

    public static class Pet {

        private final String name;
        private final String race;

        public Pet(String name, String race) {
            this.name = name;
            this.race = race;
        }

        public String getName() {
            return name;
        }

        public String getRace() {
            return race;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pet pet = (Pet) o;
            return Objects.equals(name, pet.name) && Objects.equals(race, pet.race);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, race);
        }

        @Override
        public String toString() {
            return "Pet[" +
                    "name='" + name + '\'' +
                    ", race='" + race + '\'' +
                    ']';
        }
    }

    public record Pet2(String name, String race) {}

}
