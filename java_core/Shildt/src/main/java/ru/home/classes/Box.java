package ru.home.classes;

public class Box {
    double width;
    double height;
    double depth;

    Box() {
    }

//    Box(double w, double h, double d) {
//        System.out.println("Box object construction with width x height x depth: " + w + " x " + h + " x " + d);
//        width = w;
//        height = h;
//        depth = d;
//    }

    Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    void printVolume() {
        System.out.println(this + " volume is " + width * height * depth);
    }

    double calcVolume() {
        return width * height * depth;
    }

    void setDim(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

class BoxDemo {
    public static void main(String[] args) {
        Box myBox = new Box();
        double vol;

        myBox.width = 10;
        myBox.height = 20;
        myBox.depth = 15;

        vol = myBox.depth * myBox.height * myBox.width;

        System.out.println("volume is " + vol);
    }
}

class BoxDemo2 {
    public static void main(String[] args) {
        Box myBox1 = new Box();
        Box myBox2 = new Box();
        double vol;

        myBox1.width = 10;
        myBox1.height = 20;
        myBox1.depth = 15;

        myBox2.width = 3;
        myBox2.height = 6;
        myBox2.depth = 9;

        vol = myBox1.width * myBox1.height * myBox1.depth;
        System.out.println("Box1 volume is " + vol);

        vol = myBox2.width * myBox2.height * myBox2.depth;
        System.out.println("Box2 volume is " + vol);
    }
}
class BoxDemo3 {
    public static void main(String[] args) {
        Box myBox1 = new Box();
        Box myBox2 = new Box();

        myBox1.width = 10;
        myBox1.height = 20;
        myBox1.depth = 15;

        myBox2.width = 3;
        myBox2.height = 6;
        myBox2.depth = 9;

        myBox1.printVolume();
        myBox2.printVolume();
    }
}

class BoxDemo4{
    public static void main(String[] args) {
        Box myBox1 = new Box();
        Box myBox2 = new Box();
        double vol;

        myBox1.width = 10;
        myBox1.height = 20;
        myBox1.depth = 15;

        myBox2.width = 3;
        myBox2.height = 6;
        myBox2.depth = 9;

        vol = myBox1.calcVolume();
        System.out.println("Volume is " + vol);

        vol = myBox2.calcVolume();
        System.out.println("Volume is " + vol + "\n");

        // w/o variable
        System.out.println("MyBox1 volume is " + myBox1.calcVolume());
        System.out.println("MyBox2 volume is " + myBox2.calcVolume());
    }
}

class BoxDemo5 {
    public static void main(String[] args) {
        Box myBox1 = new Box();
        Box myBox2 = new Box();

        myBox1.setDim(10,20,15);
        myBox2.setDim(3,6,9);

        myBox1.printVolume();
        System.out.println("MyBox2 volume is " + myBox2.calcVolume());
    }
}

class BoxDemo6 {
    public static void main(String[] args) {
        Box myBox1 = new Box();
        Box myBox2 = new Box();

        myBox1.printVolume();
        myBox2.printVolume();
    }
}

class BoxDemo7 {
    public static void main(String[] args) {
        Box myBox1 = new Box(10, 20, 15);
        Box myBox2 = new Box(3, 6, 9);

        myBox1.printVolume();
        myBox2.printVolume();
    }
}