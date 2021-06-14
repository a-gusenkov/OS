//Anastasia Gusenkov HW1 MW3 3220
import java.util.*;
public class Main extends pidManager {
	//main method to test pidManager class
	public static void main(String [] args) throws Exception {
		
	//Need to make method static so that
	//you can make a static reference in main. 
    //System.o.pln so that you can see what
    //values are returned on the console
		System.out.println(allocate_map());
		System.out.println(allocate_pid());
    for(int i = 500; i < 520; i++){

      System.out.println(release_pid(i));
  
    }

    System.out.println (pids.toString());
  

		
	}
}
