import java.util.concurrent.BlockingQueue;

public class Operator extends Thread {
    private BlockingQueue<Call> queue;
    private final int ANSWER_TIME = 5000;

    public Operator(BlockingQueue<Call> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (queue.isEmpty()) {
            try {
                Thread.sleep(ANSWER_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("Звонок принят " + Thread.currentThread().getName() + " " + queue.take().getNumber());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
