import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Call> calls = new LinkedBlockingQueue();
        ATS ats = new ATS(calls);
        Operator operator = new Operator(calls);

        Thread atsThread = new Thread(null, ats, "ats");

        Thread operator1 = new Thread(null, operator, "Denis");
        Thread operator2 = new Thread(null, operator, "Masha");
        Thread operator3 = new Thread(null, operator, "John");

        atsThread.start();
        operator1.start();
        operator2.start();
        operator3.start();




    }
}
