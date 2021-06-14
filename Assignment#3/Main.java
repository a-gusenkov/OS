import java.util.*;
public class Main extends pidManager {
	//main method to test Threads class
	public static void main(String [] args) throws Exception {

        pidManager pids = new pidManager();

        int num = pidManager.allocate_map();
        if (num == -1) {
            System.out.println("The pid map was not allocated");
        }
        
        int poolSize = 100;
        int sleepingTime = (int) (Math.random() * 100 + 1);
  
            Threads t1 = new Threads(pids, poolSize, sleepingTime);
            t1.run();
        
		
	}
}