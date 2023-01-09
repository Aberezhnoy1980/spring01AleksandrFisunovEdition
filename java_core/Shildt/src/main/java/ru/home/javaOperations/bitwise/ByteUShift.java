package ru.home.javaOperations.bitwise;

public class ByteUShift {
    public static void main(String[] args) {
        char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7',
                      '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
                     };

        byte b = (byte) 0xf1;
        byte c = (byte) (b >> 4);
        byte d = (byte) (b >>> 4);
        byte e = (byte) ((b & 0xff) >> 4);

        System.out.println(b + " | " + c + " | " + d + " | " + e);
        System.out.println("b = 0x" + hex[(b >> 4) & 0x0f] + hex[b & 0x0f]);
        /*
         hex[b >> 4] = [(11110001 (dec 241 (- 15) / hex 0xf1) >> 4)] = 11111111 (dec 255 (-1) / hex 0xff) = f;
         hex[0xff & 0x0f] = [11111111 (dec 255 (-1) / hex 0xff) & 00001111 (dec 15 / hex 0x0f)] = 00001111 (dec 15 / hex 0x0f) = f;
         hex[b & 0x0f] = [11110001 (dec 241 (-15) / hex 0xf1) & 00001111 (dec 15 / hex 0x0f)] = 00000001 (dec 1 / 0x1) = 1;
         total: b = 0x + hex[15] + hex[1] = 0x + f + 1 = 0xf1 (dec 241 (-15) / bin 11110001)
         */
        System.out.println("b >> 4 = 0x" + hex[(c >> 4) & 0x0f] + hex[c & 0x0f]);
           /*
         hex[c >> 4] = [(00001111 (dec 15 / hex 0x0f) >> 4)] = 00000000 (dec 0 / hex 0x0) = 0;
         hex[0x00 & 0x0f] = [00000000 (dec 0 / hex 0x0) & 00001111 (dec 15 / hex 0x0f)] = 00001111 (dec 15 / hex 0x0f) = f;
         hex[c & 0x0f] = [00001111 (dec 15 / hex 0x0f) & 00001111 (dec 15 / hex 0x0f)] = 00001111 (dec 15 / hex 0x0f) = f;
         total: b = 0x + hex[15] + hex[15] = 0x + f + f = 0xff (dec 255 (-1) / bin 11111111)
         */
        System.out.println("b >>> 4 = 0x" + hex[(d >> 4) & 0x0f] + hex[d & 0x0f]);
             /*
         hex[d >> 4] = [(00001111 (15 / 0x0f) >> 4)] = 00000000 (0 / 0x0) = 0;
         hex[0x00 & 0x0f] = [00000000 (0 / 0x0) & 00001111 (15 / 0x0f)] = 00001111 (15 / 0x0f) = f;
         hex[d & 0x0f] = [00001111 (15 / 0x0f) & 00001111 (15 / 0x0f)] = 00001111 (15 / 0x0f) = f;
         total: b = 0x + hex[15] + hex[15] = 0x + f + f = 0xff (255 (-1) / 11111111)
         */
        System.out.println("(b & 0xff) >> 4 = 0x" + hex[(e >> 4) & 0x0f] + hex[e & 0x0f]);
                /*
         hex[e >> 4] = [(11110001 (241 / 0xf1) & 11111111 (255 / 0xff)) >> 4] = 11111111 (255 / 0xff) >> 4 = 00001111 (15 / 0x0f) = f;
         hex[e >> 4] = [00001111 (15 / 0x0f) >> 4] = 00000000 (0 / 0x00) = 0;
         hex[e & 0x0f] = [00000000 (0 / 0x00) & 00001111 (15 / 0x0f)] = 00001111 (15 / 0x0f) = f;
         total: b = 0x + hex[0] + hex[15] = 0x + 0 + f = 0x0f (15 / 00001111)
         */
    }
}
