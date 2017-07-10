/**
 * BinaryMoutainFactory
 * 	Creates a small tree with 0-2 children per node.
 * 	This should be where you start testing your WumpusHunter
 * 	solution.
 *
 *      It's pretty simple, actually. We creat new "caves", passing
 *      the "parent" to the constructor, along with the cave's name
 *      and a short description string. We also indicate which cave
 *      has the golden scales and which cave is adjacent to that one.
 * 
 */


public class BinaryMountainFactory extends MountainFactory {

	
    public  MountainCave getMountainTop() {
	return getSmallStaticMountainTop();
    }
	
	
    //top is the "root" of the tree, in this case
    public  MountainCave getSmallStaticMountainTop() {
	MountainCave root = new MountainCave("Mountain Top", 
					     "The air density here seems to indicate you're not far from the base of the mountain");
	MountainCave r1 = new MountainCave(root,
					   "Clover Cove", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave l1 = new MountainCave(root,
					   "Crooked Way", "This small passage makes it difficult to see ahead");		
	MountainCave l1r = new MountainCave(l1,
					    "Hidden Nook", "The ground can't be far from here");
	MountainCave l1l = new MountainCave(l1,
					    "Snake Room", "It would seem snakes have inhabited this room in the past");		//leaf
	MountainCave l1r2l = new MountainCave(l1r,
					      "Treasure Room", "The golden scales are here!");	//leaf
		
	l1r.setAdjacentToScales(true);
	l1r2l.setHasScales(true);
		
	return root;
		
    }
	

}
