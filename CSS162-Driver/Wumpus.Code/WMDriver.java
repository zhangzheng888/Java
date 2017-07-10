/**
 * WMDriver
 * 
 * This contains a few lines of code to start things off.  Once you
 * have made a WumpusHunter subclass by extending the WumpusHunter
 * class, you'll need to change the (currently broken) line of code so
 * that it creates an object of your new class.
 * 
 * The other interesting thing here is to change the MountainFactory
 * from a Binary Tree to a 3-ary (Trinary) Tree by commenting out the
 * BinaryMountainFactory line and uncommenting the
 * TrinaryMountainFactory line below.  Note too you can make your own
 * Factories for this exercise!
 * 
 */


public class WMDriver {
	
    public static void main(String[] args) {
	/*
	 * TODO1: Change the one line below to build one of your WumpusHunters
	 */		
	WumpusHunter myHunter = new StackBasedWumpusHunter();
		
	BinaryMountainFactory caveFactory = new BinaryMountainFactory();
	//TrinaryMountainFactory caveFactory = new TrinaryMountainFactory();
	//YourMountainFactory caveFactory = new YourMountainFactory();  //only one method to do!
		
	//get the top of the mountain, which is the top of our tree
	MountainCave theBeginning = caveFactory.getMountainTop();
		
	//begin your algorithm by writing the function below for your hunter
	myHunter.startAt(theBeginning);
		
	javax.swing.JOptionPane.showMessageDialog(null, "Hunter's name: " + myHunter.getName() 
						  + "\nHunter's report:\n" + myHunter.report());
		
    }
}
