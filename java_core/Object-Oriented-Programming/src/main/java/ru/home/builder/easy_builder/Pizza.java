package ru.home.builder.easy_builder;

public class Pizza {
    private String tomato;
    private String sausage;
    private String onion;
    private String olive;
    private String cucumber;
    private String cheese;
    private int size;

    public Builder createPizza() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Your pizza with: " +
                "\n" + tomato +
                "\n" + sausage +
                "\n" + onion +
                "\n" + olive +
                "\n" + cucumber +
                "\n" + cheese +
                "\nsize is: " + size;
    }

    public static class Builder {
        private final Pizza pizza;

        public Builder() {
            this.pizza = new Pizza();
        }

        public Builder withTomato(String tomato) {
            this.pizza.tomato = tomato;
            return this;
        }
        public Builder withOnion(String onion) {
            this.pizza.onion = onion;
            return this;
        }
        public Builder withSausage(String sausage) {
            this.pizza.sausage = sausage;
            return this;
        }
        public Builder withOlive(String olive) {
            this.pizza.olive = olive;
            return this;
        }
        public Builder withCucumber(String cucumber) {
            this.pizza.cucumber = cucumber;
            return this;
        }
        public Builder withCheese(String cheese) {
            this.pizza.cheese = cheese;
            return this;
        }
        public Builder withSize(int size) {
            this.pizza.size = size;
            return this;
        }

        public Pizza build() {
            return pizza;
        }
    }
}
