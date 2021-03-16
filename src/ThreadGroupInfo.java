public class ThreadGroupInfo {

    public static void log(String indent, Thread t) {
        System.out.println(indent + "------------------------------ ");

        System.out.println(indent + "THREAD Name: " + t.getName());
        System.out.println(indent + "id: " + t.getId());
        System.out.println(indent + "priority: " + t.getPriority());
        System.out.println(indent + "State: " + t.getState());
        System.out.println(indent + "Thread Group: "
                + t.getThreadGroup().getName());
        System.out.println(indent + "is Alive: " + t.isAlive());
        System.out.println(indent + "is Daemon: " + t.isDaemon() + "\n");
    }

    public static void info(String indent, ThreadGroup tg) {

        int threadCount = tg.activeCount();
        Thread[] threads = new Thread[threadCount];
        tg.enumerate(threads); // get active threads

        System.out.println(indent + "Thread Group Name" +tg.getName());
        System.out.println(indent + "is Daemon: " + tg.isDaemon());
        // Log Threads Details
        for (int i = 0; i < threads.length; i++) {
            log(indent + "\t", threads[i]);
        }
        int groupCount = tg.activeGroupCount();
        ThreadGroup[] groups = new ThreadGroup[groupCount];
        tg.enumerate(groups);

        for (int i = 0; i < groups.length; i++) {
            info(indent + "\t", groups[i]);
        }
    }

    public static void main(String[] args) throws Exception {

        ThreadGroup tg = Thread.currentThread().getThreadGroup();
        while (tg.getParent() != null) {
            tg = tg.getParent();
            info("", tg);
        }
    }
}
