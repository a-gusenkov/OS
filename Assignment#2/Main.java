//Anastasia Gusenkov HW2 MW3 3220
import java.util.*;
public class Main extends pidManager {
	//main method to test Threads class
	public static void main(String [] args) throws Exception {
        //new pidManager declared
        pidManager pids = new pidManager();

        //The PidMap is allocated and checked for proper allocation.
        int num = pidManager.allocate_map();
        if (num == -1) {
            System.out.println("The pid map was not allocated");
        }
        //Amount of threads is declared
        int threadSize = 100;
  
            Threads t1 = new Threads(pids, threadSize);
            //run for the threads is called
            t1.run();
        
		
	}
}