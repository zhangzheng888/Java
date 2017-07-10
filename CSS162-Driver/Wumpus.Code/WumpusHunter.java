/**
 * WumpusHunter
 *
 *   This abstract class describes the two methods that you'll need to
 *   provide in your subclass - getName() and startAt().  Note that
 *   getName should be one line of code, and that all of your
 *   functionality for traversing the mountain should go in the
 *   startAt()function, which is where 98% of your code will go for
 *   this project.
 * 
 *   In your subclass, when you visit caves, add this to the actionLog
 *   string, which your subclass will have direct access to.  Then,
 *   when your hunter is done exploring you can see the list of places
 *   he/she has been, and also you can embed the solution in the
 *   actionLog if you like.
 */


public abstract class WumpusHunter {
    public abstract String getName();
    public abstract void startAt(MountainCave root); 

	
    /**
     * Use this to build a string of where your hunter has been
     */
    protected String actionLog = "\n";

    /**
     * This is called by the driver at the end to report where your
     * hunter has been.
     */
    public String report() {
	return actionLog;
    }

}
