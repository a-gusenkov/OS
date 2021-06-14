//Anastasia Gusenkov HW2 MW3 3220
//Assumptions and and restating the problem is the the design doc.
import java.util.*;
import java.lang.*;

public class Threads implements Runnable{
  //Takes in the Pid Map, the number of threads, and the random sleep time.
	private pidManager pids;
	private int threadNum;

    Threads( pidManager pids, int threadNum) {
    	this.pids = pids;
      this.threadNum = threadNum;
        
    }
    //Overrides run()
    @Override
    public void run() {
        //declares pids
        int pid1;

        //request and allocate the pids
        pid1 = pidManager.allocate_pid();
        //If it returns -1 some exception was hit in the pidManager class                                   
        if (pid1 == -1) {                      
           System.out.print("Allocation has failed.");
        }
        //Prints if allocation was successful
        System.out.println("Pids have been allocated.");

        //For the amount of threads (100) the next availible pid will
        //be requested.
        //The thread is made to sleep for a random amount of time for each pid.
        for (int i =0; i < threadNum; i++){

          //Random sleepTime is declared each time loop is called.
           int sleepingTime = (int) (Math.random() * 100 + 1);

        //Thread sleeps and a message is stated if sleep was successful or not.
        try {
        	System.out.print("Thread is sleeping.");
          Thread.sleep(sleepTime);    
          System.out.print("Thread successfully slept.");
          //Exception in case sleep was interupted. 
        } catch (InterruptedException e) {
            System.out.println("Sleep was interupted");
        }

        //After the thread has slept the pid will be released.
        try{
        	pidManager.release_pid(i);
        } catch (Exception e){
        	//exception prints out statement.
        }  
      }//end for
                             
    }
}
