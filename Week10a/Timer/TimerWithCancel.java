import java.util.Timer;
import java.util.TimerTask;

public class TimerWithCancel {
    private static int kidQuestionCount = 0;
    
    public static void main(String[] args) {
        
        // Create the timer 
        Timer kidTimer = new Timer();
        
        // Create the task to run when we get a timer message
        class RoadTripTask extends TimerTask {
            public void run() {
                System.out.println("Are we there, yet?");
                kidQuestionCount++;

                // Set up stop condition
                if (kidQuestionCount >= 10) {
                    System.out.println("WE'RE HERE, NOW!");
                    kidTimer.cancel();
                }
            }
        }
        // Start the timer running now, and pinging us every second
        kidTimer.schedule(new RoadTripTask(), 0, 1 * 1000);
    }

}
