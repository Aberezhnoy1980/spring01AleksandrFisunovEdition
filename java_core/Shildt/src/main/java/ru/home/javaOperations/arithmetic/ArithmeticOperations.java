package ru.home.javaOperations.arithmetic;

/*
+ сложение (а также унарный плюс)
- вычитание (а также унарный минус)
* умножение
/ деление
% деление по модулю
++ инкремент (приращение на 1)
+= сложение с присваиванием
-= вычитание с присваиванием
*= умножение с присваиванием
/= деление с присваиванием
%= деление по модулю с присваиванием
-- декремент (отрицательное приращение на 1)
 */
public class ArithmeticOperations {
    public static void main(String[] args) {
        // про типы значений коротко тут https://www.math10.com/ru/algebra/chisla.html)
        System.out.println("Целочисленная арифметика");
        int a = 1 + 1;
        int b = a * 3;
        int c = b / 4;
        int d = c - a;
        int e = -d;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);

        System.out.println("\nАрифметика с плавающей точкой");
        double da = 1 + 1;
        double db = da * 3;
        double dc = db / 4;
        double dd = dc - da;
        double de = - dd;
        System.out.println("da = " + da);
        System.out.println("db = " + db);
        System.out.println("dc = " + dc);
        System.out.println("dd = " + dd);
        System.out.println("de = " + de);
    }
}
