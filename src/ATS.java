import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ATS extends Thread {
    private final int CALLS_AMOUNT = 10;
    private final int CALLS_RHYTHM = 2000;
    private BlockingQueue<Call> queue;

    public ATS (BlockingQueue<Call> calls) {
        this.queue = calls;
    }

    @Override
    public void run() {
        for (int i = 0; i < CALLS_AMOUNT; i++) {
            try {
                queue.put(new Call(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Ring Ring # " + i);
            try {
                Thread.sleep(CALLS_RHYTHM);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
