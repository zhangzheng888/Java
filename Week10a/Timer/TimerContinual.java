import java.util.Timer;
import java.util.TimerTask;

public class TimerContinual {

    public static void main(String[] args) {
        
        // Create the timer 
        Timer kidTimer = new Timer();
        
        // Create the task to run when we get a timer message
        class RoadTripTask extends TimerTask {
            public void run() {
                System.out.println("Are we there, yet?");
            }
        }
        // Start the timer running now, and pinging us every second
        kidTimer.schedule(new RoadTripTask(), 0, 1 * 1000);
    }

}
