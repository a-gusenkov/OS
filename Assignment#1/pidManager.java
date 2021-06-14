//Anastasia Gusenkov HW1 MW3 3220
//Assumptions and and restating the problem is the the design doc.
import java.util.*;
public class pidManager {
	
	//Set instance varibales to identify
	//range of pid values
	
	private static int MIN_PID = 300;
	private static int MAX_PID = 5000;
	
	//Creates an array list to represent the pid.
	static ArrayList<Integer> pids = new ArrayList<Integer>();
	
	public static int allocate_map() throws Exception {
		
		//Sets value of 0 for the range of 4700
		//which is the possible range of pid value
		//from 300 to 5000.
		for(int i=0; i < MAX_PID - MIN_PID; i++) {
			pids.add(0);
		}
		//When initialization failed returns value of -1.
		if(pids.isEmpty()) {
			return -1;
		}
		//If initialization is successful returns 1.
		return 1;
		
	}
	public static int allocate_pid() {
		//Value that will be returned.
		int i;
		
		//When pids are not initilialized return -1
		//since allocation cannot happen. 
		if(pids.isEmpty()) {
			return -1;
		}
		
		for(i =0 ; i< pids.size(); i++) {
			//Allocates pids when the process id of value at i 
			// is available (determined by 0).
			if(pids.get(i) == 0) {
				pids.set(i,1);
				//If allocation fails by not setting the value
				//at index to 1 -1 is returned.
			    if(pids.get(i) == 0) {
			    	return -1;
			    }
			}
		}
    System.out.println (pids.toString());
		//returns the last index the pid is allocated.

    System.out.println("The last pid allocated at index: ");
		return i + MIN_PID;
		
		
	}
	public static int release_pid(int int_pid) throws Exception {
		
		//Exception thrown when the pids are not initialized.
		if(pids.isEmpty()) {
			throw new Exception("Cant release a pid since they are not initialized");
		}
		//Exception thrown when the index to release of pids is not in range.
		else if(int_pid < MIN_PID || int_pid > MAX_PID) {
			throw new IndexOutOfBoundsException();
		}
		//Exception thrown when the pids at the index is already released.
    //int_pid is subtracted by MIN_PID
      //becuase in this array list index 300
      //is represented by 0
		else if (pids.get(int_pid - MIN_PID) == 0) {
			throw new Exception("pid is already released");
		}
		//When all the exceptions are passed the pids is released
		//by setting the value at the index to 0.
		else {
      //int_pid is subtracted by MIN_PID
      //becuase in this array list index 300
      //is represented by 0
			pids.set(int_pid - MIN_PID, 0);
			System.out.println("The pid at index this following is released:");
			return int_pid;
		}
	}

}