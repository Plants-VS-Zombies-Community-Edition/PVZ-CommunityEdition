package pvz.community;

public class SystemUtils implements Runnable{

    private final Thread clockThread;

    public int seconds = 0;
    public int minutes = 0;
    public int hours = 0;
    public int days = 0;
    public int weeks = 0;

    public SystemUtils() {
        clockThread = new Thread(this);
        clockThread.start();
    }


    @Override
    public void run() {
        while (clockThread != null) {
            seconds++;
            if (seconds == 60) {
                seconds = 0;
                minutes++;
            }
            if (minutes == 60) {
                minutes = 0;
                hours++;
            }
            if (hours == 24) {
                hours = 0;
                days++;
            }
            if (days == 7) {
                days = 0;
                weeks++;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public String getUptime() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public int convertMSToS(int ms) {
        return ms / 1000;
    }

    public int convertNanoToMS(long nano) {
        return (int) (nano / 1000000);
    }

}
