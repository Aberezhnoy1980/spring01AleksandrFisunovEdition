package ru.home.javaOperations.bitwise;

import java.lang.reflect.Field;

/*
~ поразрядная унарная операция НЕ
& поразрядная логическая операция И
| поразрядная логическая операция ИЛИ
^ поразрядная логическая операция исключающая ИЛИ
>> сдвиг вправо
>>> сдвиг вправо с заолнением нулями
<< сдвиг влево
&= поразрядная логическая операция И с присваиванием
|= поразрядная логическая операция ИЛИ с присваиванием
^= поразрядная логическая операция исключающее ИЛИ с присваиванием
>>= сдвиг вправо с присваиванием
>>>= сдвиг вправо с заполнением нулями и присваиванием
<<= сдвиг влево с присваиванием
 */
public class BitLogic {
    static int a = 3; // 0 + 2 + 1, or 0011 in bin
    static int b = 6; // 4 + 2 + 0, or 0110 in bin
    static int c = a | b; // result in bin = 0111, or 4 + 2 + 1 = 7 in dec
    static int d = a & b; // result in bin = 0010, or 0 + 2 + 0 = 2 in dec
    static int e = a ^ b; // result in bin = 0101, or 4 + 0 + 1 = 5 in dec
    static int f = (~a & b) | (a & ~b); // result in bin = (1100 & 0110 = 0100) | (0011 & 1001 = 0001) = 0101, or 4 + 0 + 1 = 5
    static int g = ~a & 0x0f; // 1100 & 1111 = 1100, or 8 + 4 + 0 + 0 = 12

    public static void main(String[] args) throws IllegalAccessException {
        String[] binary = {"0000", "0001", "0010", "0011", "0100", "0101",
                "0110", "0111", "1000", "1001", "1010", "1011",
                "1100", "1101", "1110", "1111"};


        extracted(binary, f);
    }

    private static void extracted(String[] binary, int arg) throws IllegalAccessException {
        BitLogic bl = new BitLogic();
        Field[] fd = bl.getClass().getDeclaredFields();
        String name = null;
        for (Field i : fd) {
            if (i.getInt(bl) == arg) {
                name = i.getName();
                break;
            }
        }

        for (int i = 0; i < binary.length; i++) {
            int decNum = i + 1;
//            System.out.print(decNum + " ");
            //Integer.parseInt(binary[i + 1]);
            if (decNum == arg) {
                System.out.println(name + " expression in bin = " + binary[i + 1] + " , or in dec = " + decNum);
            }
        }
    }

}
