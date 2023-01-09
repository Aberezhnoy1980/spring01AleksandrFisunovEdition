package ru.aberezhnoy.homework01.check_code;

abstract class Car { //Непривычно, что класс не public, но не исключено, что автор осознанно сделал пакетный доступ
    private Engine engine; // изначально был модификатор public, а делать поля публичными очень не не рекомендовано,
    //разве тольк в крайних случаях. А тут и смысла в этом нет, т.к. в коде есть и геттер и сеттер.
    private String color;
    private String name;

    protected void start() {//ну.. как бы если класс сам по себе доступен только в рамках пакета, зачем расширять
        //доступ к методу до protected? т.е. можно тут модификатор доступа убрать просто и никто не пострадает.
        System.out.println("Car starting");
    }

    abstract void open();

    public Engine getEngine() {  //Вариант оптимизации - подключить lombok, но тут полей, вроде, немного, поэтому можно и так оставить
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car(Engine engine, String color, String name) { // Опционально: возможно, все-таки удобнее будет создавать
        //объекты классов-наследников, сразу задавая значения полей через конструктор, а не через сеттеры. Но тут
        //вопрос к автору кода в части идеи - не факт, что предложенный вариант с конструктором является оптимизацией.
        //Может, наоборот, это усложнение и никто при создании объектов не собирается сразу определять значения полей.
        this.engine = engine;
        this.color = color;
        this.name = name;
    }
}
