package pvz.community.scheduler;

public interface Scheduler {


    int getId();

    void run();
    void cancel();
    boolean isRunning();


}
