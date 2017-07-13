import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        
        Random myRand = new Random();
        HashIntSet myInts = new HashIntSet();
        for (int aNum = 0; aNum < 10; aNum++) {
            int rand = myRand.nextInt(1000);
            myInts.add(rand);
        }
        int x = 1;
    }
}
