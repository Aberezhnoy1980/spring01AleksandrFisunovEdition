package ru.home.javaOperations.logics;

/*
& логическая оперция И
| логическая операция ИЛИ
^ логическая операция исключаещее ИЛИ
|| укороченная логическая операция ИЛИ
&& укороченная логичечская операция И
! логическая унарная операция НЕ
&= логическая операция И с присваиванием
|= логическая операция ИЛИ с присваиванием
^= логическая операция исключаещее ИЛИ с присваиванием
== равенство
!= неравенство
?: тернарная условная операция типа если..., то..., иначе...

результаты выполнения логических операций
________________________________________________
   A   |   B   | A | B | A & B | A ^ B | !(~)A
------------------------------------------------
 false |false  | false | false | false | true
   0   |   0   |   0   |   0   |   0   |   1
 true  | false | true  | false | true  | false
   1   |   0   |   1   |   0   |   1   |   0
 false | true  | true  | false | true  | true
   0   |   1   |   1   |   0   |   1   |   1
 true  | true  | true  | true  | false | false
   1   |   1   |   1   |   1   |   0   |   0
 */


public class BoolLogic {
    public static void main(String[] args) {
        boolean a = true; // true
        boolean b = false; // false
        boolean c = a | b; // true
        boolean d = a & b; // false
        boolean e = a ^ b; // true
        boolean f = (!a & b) | (a & !b); // true
        boolean g = !a; // false

        System.out.println("                  a = " + a);
        System.out.println("                  b = " + b);
        System.out.println("              a | b = " + c);
        System.out.println("              a & b = " + d);
        System.out.println("              a ^ b = " + e);
        System.out.println("(!a & b) | (a & !b) = " + f);
        System.out.println("                 !a = " + f);
    }
}
