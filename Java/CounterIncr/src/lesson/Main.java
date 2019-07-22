package lesson;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 1. (Обязательное)\n" +
                "Напишите класс, реализующий интерфейс Runnable, содержащий поле-счетчик. \n" +
                "Метод run() должен наращивать этот счетчик. \n" +
                "Создайте пять экземпляров этого класса и запустите их в пяти потоках \n" +
                "с разными приоритетами. \n" +
                "После 3 секунд работы остановите потоки и сравните значения счетчиков.");

        System.out.println("\n\nПриоритет текущего потока (main): " + Thread.currentThread().getPriority());

        System.out.println("");

        counterIncr ci1 = new counterIncr();
        Thread t1 = new Thread(ci1);
        t1.setDaemon(true);
        t1.setPriority(2);
        t1.start();

        counterIncr ci2 = new counterIncr();
        Thread t2 = new Thread(ci2);
        t2.setDaemon(true);
        t2.setPriority(4);
        t2.start();

        counterIncr ci3 = new counterIncr();
        Thread t3 = new Thread(ci3);
        t3.setDaemon(true);
        t3.setPriority(6);
        t3.start();

        counterIncr ci4 = new counterIncr();
        Thread t4 = new Thread(ci4);
        t4.setDaemon(true);
        t4.setPriority(8);
        t4.start();

        counterIncr ci5 = new counterIncr();
        Thread t5 = new Thread(ci5);
        t5.setDaemon(true);
        t5.setPriority(10);
        t5.start();

        long start = System.currentTimeMillis();
        long end;
        long time = 0;
        System.out.print("Процесс идёт: ->  ");
        while (time <= 3000) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            end = System.currentTimeMillis();
            time = end - start;
        }

        System.out.println("\n\n");


        System.out.print("Поток " + t1.getName() +
                " с приоритетом " + t1.getPriority() +
                " инкрементировал счётчик до ");System.out.println(ci1.getCounter());
        System.out.print("Поток " + t2.getName() +
                " с приоритетом " + t2.getPriority() +
                " инкрементировал счётчик до ");System.out.println(ci2.getCounter());
        System.out.print("Поток " + t3.getName() +
                " с приоритетом " + t3.getPriority() +
                " инкрементировал счётчик до ");System.out.println(ci3.getCounter());
        System.out.print("Поток " + t4.getName() +
                " с приоритетом " + t4.getPriority() +
                " инкрементировал счётчик до ");System.out.println(ci4.getCounter());
        System.out.print("Поток " + t5.getName() +
                " с приоритетом " + t5.getPriority() +
                " инкрементировал счётчик до ");System.out.println(ci5.getCounter());

        System.out.format("\nВремя выполнения программы - %1.2f секунды\n\n", (float) time / 1000);
    }
}
