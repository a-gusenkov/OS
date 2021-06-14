//Anastasia Gusenkov CISC 3320
//Restate the problem and assumptions
//are all in the design doc
package OS;

import java.util.ArrayList;
import java.util.Collections;
public class diskSchedulingAlgorithms {
	//variables for size of track request and number of cylinders
	static int trackSize = 50;

	//FCFS Algorithm
	//does not need a direction
	public static int FCFS(int trackRequests[], int initHeadPos){
		//checks that the track requests aren't empty
		if(trackRequests.length == 0) {
			System.err.println("There is no head.");
		}
		int count = 0;
		
		//loops through entire track request
		//assigns a variables to the value at a track
		//and figures out the number of head movements
		//from head to the next track in the array.
		//Adds the # of movements to count
		//and then goes to the next track
		for(int index = 0; index < trackSize; index++){
	        //calculates head movements and adds to overall count
			count += Math.abs(trackRequests[index] - initHeadPos );
			//this track now becomes the head position
			initHeadPos = trackRequests[index];
		}

		return count;

	}
	
	
	//LOOK Algorithm
	public static int LOOK(int trackRequests[], int headPosition, String direction){
		int count = 0;
		
		if(trackRequests.length == 0) {
			System.err.println("There is no head.");
		}
	
		//when track is less than head its on the left side
		ArrayList <Integer> lessThanHead = new ArrayList<Integer>();
		//when track is more than head its on the right side
		ArrayList <Integer> moreThanHead = new ArrayList<Integer>();

		//Separates track requests into the left and right side
		for(int index = 0; index < trackSize; index++){
			if (trackRequests[index] < headPosition) {
				lessThanHead.add(trackRequests[index]);
			}
			else if (trackRequests[index] > headPosition) {
				moreThanHead.add(trackRequests[index]);
			}
		}
		
		//sorts in descending order so that when its time to
		//reverse direction loop can start from
		//index 0
		Collections.sort(lessThanHead, Collections.reverseOrder());
		//sorts in ascending order
		Collections.sort(moreThanHead);

 
		//if starting direction is equal to right
		//algorithm moves from head right until there are no more requests
		//and is in the end
		//then reverses direction to left until the start

	    if(direction == "right"){
	    	//going right
	        for(int index = 0; index < moreThanHead.size(); index++){
	            count += Math.abs(moreThanHead.get(index) - headPosition);
	            headPosition = moreThanHead.get(index);
	        }
	        //then reversing and going left
	        for(int index = 0; index < lessThanHead.size(); index++){
	            count += Math.abs(lessThanHead.get(index) - headPosition);
	            headPosition = lessThanHead.get(index);
	        }
	    }
	    
	    //if starting direction is equal to left
	    //algorithm moves left from head until there are no more requests
	    //and is in the start position
		//then reverses direction to right until the end

	    if(direction == "left"){
	    	//going left
	        for(int index = 0; index < lessThanHead.size(); index++){
	            count += Math.abs(lessThanHead.get(index) - headPosition);
	            headPosition = lessThanHead.get(index);
	        }
	        //reversing and going right
	        for(int index = 0; index < moreThanHead.size(); index++){
	            count += Math.abs(moreThanHead.get(index) - headPosition);
	            headPosition = moreThanHead.get(index);
	        }
	        

	    }
	    return count;
	}
	
	//C-LOOK Algorithm
	public static int CLOOK(int trackRequests[], int initHeadPos, String direction){
	    int count = 0;
	    
		if(trackRequests.length == 0) {
			System.err.println("There is no head.");
		}
	     
		//when track is less than head its on the left side
		ArrayList <Integer> lessThanHead = new ArrayList<Integer>();
		//when track is more than head its on the left side
		ArrayList <Integer> moreThanHead = new ArrayList<Integer>();
		
		//Separates track requests into the left and right side
		for(int index = 0; index < trackSize; index++){
		    if (trackRequests[index] <= initHeadPos) {
		    	lessThanHead.add(trackRequests[index]);
		    }
		    else if (trackRequests[index] > initHeadPos) {
		    	moreThanHead.add(trackRequests[index]);
		    }
		}
	  
		//Sorts all the requests
	    Collections.sort(lessThanHead); 
	    Collections.sort(moreThanHead); 

	    //If the starting direction is right
	    if(direction == "right") {
	    
	    //starts with initial head position
	    //and continues to the right adding the
	    //head movements to the next larger track request
	    	for(int i = 0; i < moreThanHead.size(); i++){
	    		count += Math.abs(moreThanHead.get(i) - initHeadPos);
	    		initHeadPos = moreThanHead.get(i);
	    	}
	    //once all the larger requests are done
	    //head becomes the start of the
	    //left side
	    
	    //and adds the amount of head movements
	    //from end of track
	    //to the start
	    	count += Math.abs(lessThanHead.get(0) - initHeadPos);
	    	initHeadPos = lessThanHead.get(0);

	    //Ascends through track requests
	    //now from the smallest track request value
	    //until the head
	    	for(int i = 0; i < lessThanHead.size(); i++){
	    		count += Math.abs(lessThanHead.get(i) - initHeadPos);
	    		initHeadPos = lessThanHead.get(i);
	    	}
	    }
	    
	    //If the starting direction is left
	    if(direction == "left") {
	    	
	    	//Starts from head and moves to the left
	    	//adding up the head movements
	    	//until the start is reached
		    for(int i = lessThanHead.size(); i < 0; i--){
		    	count += Math.abs(lessThanHead.get(i) - initHeadPos);
		    	initHeadPos = lessThanHead.get(i);
		    }
		    //head becomes the end of the
		    //track requests on the right side. 
		    
		    //and adds the amount of head movements
		    //from start of track
		    //to the end
		    count += Math.abs(moreThanHead.get(moreThanHead.size() -1 ) - initHeadPos);
		    initHeadPos = moreThanHead.get(moreThanHead.size() -1 );
	    	
		    //Descends from end back to the head.
		    //Meanwhile adding up all the number
		    //of head movements.
		    for(int i = lessThanHead.size()-1; i >= 0; i--){
		    	count += Math.abs(lessThanHead.get(i) - initHeadPos);
		    	initHeadPos = lessThanHead.get(i);
		    }
	    }
	     
	    return count;
	   
	}
}
