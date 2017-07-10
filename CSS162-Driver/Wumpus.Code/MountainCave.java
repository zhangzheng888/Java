import java.util.ArrayList;

/*
 * 
 * MountainCave.java
 *
 *   This class is built for this exercise only, and has some serious
 *   flaws "by design" just so we could traverse the tree directly
 *   from our WumpusHunter code. For a better design, we would have
 *   separate classes for the tree and internal nodes (rather than
 *   packing them together here), and we'd never return private
 *   aliases for our nodes. And the list goes on...
 *
 *   To try to keep things organized, I have sorted the methods into
 *   those you can call from your MyWumpusHunter, those called from a
 *   MountainFactory, and internal stuff you shouldn't need to mess
 *   with.
 * 
 */

public class MountainCave {


    // The following are accessors for your Hunter

    public String getCaveName() {
	return caveName;
    }
	
    public ArrayList getChildren() {
	return children;
    }
	
    public String getCaveMessage() {
	return caveMessage;
    }

    public boolean hasScales() {
	return hasWumpusScales;
    }

    public boolean isAdjacentToScales() {
	return isAdjacentToScales;
    }


    // Next, we have methods that we call from a MountFactory:
    
    /**
     * This is the preferred constructor to use. It "attaches" the
     * cave to its parent (and the parent to its child) and assigns it
     * a name and description. The other constructors are near the end
     * of the class.
     */
    public MountainCave(MountainCave theParent, String name, String message)
    {
	this(name, message);
	if( theParent != null) {
	    parent = theParent;
	    parent.addChild(this);
	}
    }
	
    public void setAdjacentToScales(boolean adjacentToScales) {
	this.isAdjacentToScales = adjacentToScales;
    }
	
    public void setHasScales(boolean hasWumpusScales) {
	this.hasWumpusScales = hasWumpusScales;
    }



    public void setCaveMessage(String caveName) {
	this.caveName = caveName;
    }



    // And finally, methods that are used internally and that you are
    // unlikely to need to use.

    public MountainCave(String name, String message) {
	caveName = name;
	caveMessage = message;
    }

    public MountainCave(String name){
	this(name,null);
    }	
	
    public void setParent(MountainCave theParent) {
	parent = theParent;
	parent.addChild(this);
    }
	
    public void addChild(MountainCave next) {
	if( next != null ) {
	    children.add(next);
	}
    }
	
    public MountainCave getParent() {
	return parent;
    }
	
    public boolean hasParent()
    {
	if(parent == null) {
	    return false;
	}
	return true;
    }

    //node structure pointers
    private MountainCave parent = null;
    private ArrayList<MountainCave> children = new ArrayList<MountainCave>();
    //end node
	
    //MountainCave data items
    private String caveMessage = null;
    private String caveName = null;
	
    private boolean isAdjacentToScales=false;
    private boolean hasWumpusScales=false;
    //end MountainCave
	

}
