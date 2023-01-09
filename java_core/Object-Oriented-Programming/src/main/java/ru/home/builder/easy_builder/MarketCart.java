package ru.home.builder.easy_builder;

public class MarketCart {
    private Bread bread;
    private Sausage sausage;
    private Oil oil;
    private Milk milk;

    public MarketCart(CartBuilder cartBuilder) {
        this.bread = cartBuilder.bread;
        this.sausage = cartBuilder.sausage;
        this.oil = cartBuilder.oil;
        this.milk = cartBuilder.milk;
    }

    @Override
    public String toString() {
        return "Your cart consist: " +
                "\n" + bread + ": " +
                "\n" + sausage + ": " +
                "\n" + oil + ": " +
                "\n" + milk + ": ";
    }

    public static class CartBuilder {
        private Bread bread;
        private Sausage sausage;
        private Oil oil;
        private Milk milk;

        public CartBuilder includeBread(Bread bread) {
            this.bread = bread;
            return this;
        }

        public CartBuilder includeSausage(Sausage sausage) {
            this.sausage = sausage;
            return this;
        }

        public CartBuilder includeOil(Oil oil) {
            this.oil = oil;
            return this;
        }

        public CartBuilder includeMilk(Milk milk) {
            this.milk = milk;
            return this;
        }

        public MarketCart build() {
            return new MarketCart(this);
        }
    }
}

class Oil {
    private String type;
    private int size;

    public static OilBuilder createOil() {
        return new OilBuilder();
    }

    @Override
    public String toString() {
        return "Oil{" +
                "type='" + type + '\'' +
                ", size=" + size + " g." +
                '}';
    }

    static class OilBuilder {
        private final Oil oil;

        public OilBuilder() {
            this.oil = new Oil();
        }

        public OilBuilder withType(String type) {
            this.oil.type = type;
            return this;
        }

        public OilBuilder withSize(int size) {
            this.oil.size = size;
            return this;
        }

        public Oil build() {
            return oil;
        }
    }
}

class Sausage {
    private String type;
    private int size;

    public static SausageBuilder createSausage() {
        return new SausageBuilder();
    }

    public String toString() {
        return "Sausage{" +
                "type='" + type + '\'' +
                ", size=" + size + " g." +
                '}';
    }

    static class SausageBuilder {
        private final Sausage sausage;

        public SausageBuilder() {
            this.sausage = new Sausage();
        }

        public SausageBuilder withType(String type) {
            this.sausage.type = type;
            return this;
        }

        public SausageBuilder withSize(int size) {
            this.sausage.size = size;
            return this;
        }

        public Sausage build() {
            return sausage;
        }
    }
}

class Bread {
    private String type;
    private int size;

    public String toString() {
        return "Bread{" +
                "type='" + type + '\'' +
                ", size=" + size + " g." +
                '}';
    }
    public static BreadBuilder createBread() {
        return new BreadBuilder();
    }

    static class BreadBuilder {
        private final Bread bread;

        public BreadBuilder() {
            this.bread = new Bread();
        }

        public BreadBuilder withType(String type) {
            this.bread.type = type;
            return this;
        }

        public BreadBuilder withSize(int size) {
            this.bread.size = size;
            return this;
        }

        public Bread build() {
            return bread;
        }
    }
}

class Milk {
    private String type;
    private int size;

    public String toString() {
        return "Milk{" +
                "type='" + type + '\'' +
                ", size=" + size + " g." +
                '}';
    }
    public static MilkBuilder createMilk() {
        return new MilkBuilder();
    }

    static class MilkBuilder {
        private final Milk milk;

        public MilkBuilder() {
            this.milk = new Milk();
        }

        public MilkBuilder withType(String type) {
            this.milk.type = type;
            return this;
        }

        public MilkBuilder withSize(int size) {
            this.milk.size = size;
            return this;
        }

        public Milk build() {
            return milk;
        }
    }
}
