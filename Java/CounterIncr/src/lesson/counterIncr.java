package lesson;

public class counterIncr implements Runnable {

    long counter = 0;


    public long getCounter() {
        return counter;
    }

    @Override
    public void run() {

        //try {
        while (true) {
            counter++;
            //Thread.sleep(1);
            //}
            //} catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }
}
