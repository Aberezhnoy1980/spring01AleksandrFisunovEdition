package ru.aberezhnoy.array;

public class MyArray implements ArrayOps {

    private int[] intArr;
    private Cat[] catArr;
    private int size;

    private MyArray() {
    }

    private MyArray(int size) {
        this.intArr = new int[size];
        this.catArr = new Cat[size];
        this.size = size;
    }

//    public static MyArray createMyArray(int[] intArr, Cat[] catArr, int size) {
//        return new MyArray(intArr, catArr, size);
//    }

    public static ArrayBuilder createArrayBuilder() {
        return new ArrayBuilder();
    }

    @Override
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(intArr[i] + " ");
        }
        System.out.println();
    }

    @Override
    public void insertInSortedArray(int value) {
        int i = 0;
        for (i = 0; i < this.size; i++) {
            if (this.intArr[i] > value) break;
        }
        for (int j = this.size; j > i; j--) {
            this.intArr[j] = this.intArr[j - 1];
        }
        this.intArr[i] = value;
        this.size++;
    }

    @Override
    public void insertInUnsortedArray(int value) {
        this.intArr[this.size] = value;
        this.size++;
    }

    @Override
    public boolean lineFind(int value) {
        for (int i = 0; i < size; i++) {
            if (this.intArr[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean BinaryFindInSortedArray(int value) {
        int low = 0;
        int mid;
        int high = size - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (value == this.intArr[mid]) {
                return true;
            } else {
                if (value < this.intArr[mid]) {
                    high = mid - 1;
                } else low = mid + 1;
            }
        }
        return false;
    }

    @Override
    public void delete(int value) {
        int i = 0;
        for (i = 0; i < size; i++) {
            if (this.intArr[i] == value) break;
        }
        for (int j = i; j < this.size - 1; j++) {
            this.intArr[j] = this.intArr[j + 1];
        }
        this.size--;
    }

    @Override
    public void sortBubble() {
        int out, in;
        for (out = this.size - 1; out >= 1; out--) {
            for (in = 0; in < out; in++) {
                if (this.intArr[in] > this.intArr[in + 1]) {
                    change(in, in + 1);
                }
            }
        }
    }

    @Override
    public void sortSelect() {
        int in, out, mark;
        for (out = 0; out < this.size; out++) {
            mark = out;
            for (in = out + 1; in < this.size; in++) {
                if (this.intArr[in] < intArr[mark]) {
                mark = in;
                }
            }
            change(out, mark);
        }
    }

    @Override
    public void change(int a, int b) {
        int temp = this.intArr[a];
        this.intArr[a] = this.intArr[b];
        this.intArr[b] = temp;
    }

    @Override
    public void sortInsert() {
        int in, out;
        for (out = 1; out < this.size; out++) { // first tact
            int temp = this.intArr[out]; // out=1, temp=4
            in = out; // in=1
            while (in > 0 && this.intArr[in - 1] >= temp) { // 1>0, 5>4 true| 0>0 false
                this.intArr[in] = this.intArr[in - 1]; // 4=5
                --in; // 0
            }
            this.intArr[in] = temp; // 5=4
        }
    }

    @Override
    public void arrayLengthCut(int value) {
        MyArray.this.size -= value;
    }

    public static class ArrayBuilder {
        private final MyArray myArray;

        public ArrayBuilder() {
            this.myArray = new MyArray();
        }

        public ArrayBuilder setIntArray(int size) {
            this.myArray.intArr = new int[size];
            return this;
        }

        public ArrayBuilder setCatArray(int size) {
            this.myArray.catArr = new Cat[size];
            return this;
        }

        public ArrayBuilder setArraySize(int size) {
            this.myArray.size = 0;
            return this;
        }

        public MyArray build() {
            return myArray;
        }
    }
}
