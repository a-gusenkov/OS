import java.util.*;
import java.lang.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Threads implements Runnable{

	private pidManager pids;
	private int threadNum;
  private int sleepTime;

    Threads( pidManager pids, int threadNum , int sleepTime) {
    	this.pids = pids;
      this.threadNum = threadNum;
      this.sleepTime = sleepTime;
        
    }

    @Override
    public void run() {

        int pid1;
        //declares new Lock bjects from the 
        lockAllocate = new ReentrantLock();
        lockRelease = new ReentrantLock();

        try {
          //allocation of a pid is now locked
          lockAllocate.lock();
          //request and allocate the pid
           pid1 = pidManager.allocate_pid();

        } finally {
            //allocation of a pid is now unlocked
            lockAllocate.unlock(); 
        } 

        if (pid1 == -1) {                      
           System.out.print("Allocation has failed.");
        }
        System.out.println("Pids have been allocated.");

      for (int i =0; i < threadNum; i++){
        //sleep for a random period of time
        try {
        	System.out.print("Thread is sleeping.");
          Thread.sleep(sleepTime);    
          System.out.print("Thread successfully slept.");
        } catch (InterruptedException e) {
            System.out.println("Sleep was interupted");
        }

        
        try {
        //Release of a pid is now locked
        lockRelease.lock();
        //release the pid
          try{
        	  pidManager.release_pid(i);
          } catch (Exception e){
        	//exception prints out statement
          }  

        } finally {
            //release of a pid is now unlocked
            lockRelease.unlock(); 
        }
      }//end for loop
                             
    }
}
