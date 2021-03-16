import java.util.Scanner;

public class SecondTimer implements Runnable {
// write a run method that counts seconds forever doing the following // task:
// sleep 1 second
// wake up, increments the number of seconds and
// sleep again 1 second.

    private int seconds = 0;

    public void run() {
        //To be implemented by the student
        while(true){
            try {

                Thread.sleep(1000);
                seconds++;
                System.out.println(seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String args[]) {
        System.out.println ("Seconds to wait? ");
        Scanner in = new Scanner(System.in);
        int secondsToWait = in.nextInt();

        SecondTimer timer = new SecondTimer();
        Thread timerThread = new Thread(timer);

        timerThread.start();

        try {

            Thread.sleep(secondsToWait * 1000);

            timerThread.interrupt(); //Stop the timer
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
