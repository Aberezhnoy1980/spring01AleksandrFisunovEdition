package ru.home.lesson5;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {
//        MyThread mt1 = new MyThread();
//        mt1.start();
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//            try {
//                Thread.sleep(20);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        Thread myRunnableThread = new Thread(new MyRunnable());
//        myRunnableThread.start();

        // public class MainApp$1 implements Runnable {
        //   @Override
        //   public void rin() {
        //     for (int i = 0; i < 10; i--) {
        //       System.out.println(i);
        //     }
        //   }
        // }
        // Thread t = new Thread(new MainApp$1());

//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//                for (int i = 0; i < 10; i++) {
//                    System.out.println(i);
//                }
//            }
//        });
//        t.start();
//
//        System.out.println(Thread.currentThread().getName());

//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 20; i++) {
//                    System.out.println(Thread.currentThread().getName() + " - " + i);
//                    try {
//                        Thread.sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        t1.start(); // Always only start

//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 20; i++) {
//                    System.out.println(Thread.currentThread().getName() + " - " + i);
//                    try {
//                        Thread.sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        t1.start();
//        t2.start();

//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(1);
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(2);
//            }
//        });
//        t1.start();
//        t2.start();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(i);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("END");
    }
}