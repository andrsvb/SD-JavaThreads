public class TaskHello implements Runnable {

    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void info (Thread t)  {
        //print all the following atributes of t
        //-	name
        System.out.println("Thread name: " + t.getName());
        //-	id
        System.out.println("Thread id: " + t.getId());
        //-	priority
        System.out.println("Thread priority: " + t.getPriority());
        //-	state
        System.out.println("Thread state: " + t.getState().toString());
        //-	ThreadGroup
        System.out.println("Thread group: " + t.getThreadGroup().toString());
        //-	ThreadGroup Name
        System.out.println("Thread group name: " + t.getThreadGroup().getName());
        //-	if it is alive
        System.out.println("Thread alive? " + t.isAlive());
        //-	If it is a daemon
        System.out.println("Thread daemon? " + t.isDaemon());
    }


    public static void main(String args[]) {
        /* 1.1
        TaskHello taskHello = new TaskHello();
        Thread  threadHello = new Thread(taskHello);
        threadHello.start();    */

        /* 1.2
        (new Thread(new TaskHello())).start();
        */

        TaskHello taskHello = new TaskHello();
        Thread  threadHello1 = new Thread(taskHello);
        Thread  threadHello2 = new Thread(taskHello);
        threadHello1.run();
        threadHello2.run();
        Thread mth = Thread.currentThread();

        info(threadHello1);
        info(threadHello2);
        info(mth);
    }

}
