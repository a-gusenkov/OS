//Anastasia Gusenkov CISC 3320
package OS;

public class Main extends diskSchedulingAlgorithms {

	//Variable for initial head position
	static int initHeadPos = 100;
	
	public static void main(String[] args) {
		
		//array that will be used as use the set of 50 track requests 
		int trackRequests[] = { 4078, 153, 2819, 3294, 1433, 211, 1594, 2004, 2335,
		        2007, 771, 1043, 3950, 2784, 1881, 2931, 3599, 1245, 4086, 520, 3901,
		        2866, 947, 3794, 2353, 3970, 3948, 1815, 4621, 372, 2684, 3088, 827,
		        3126, 2083, 584, 4420, 1294, 917, 2881, 3659, 2868, 100, 1581, 4581,
		        1664, 1001, 1213, 3439, 4706 };

		

		//calling of all the algorithms
		//in this case we will move algorithms to the right first
		//However, you can also have the starting direction as
		//left
		System.out.print("FCFS Number of Head Movements : "  + FCFS(trackRequests, initHeadPos));
		System.out.print("\nLOOK Number of Head Movements : " + LOOK(trackRequests, initHeadPos, "right"));
		System.out.print("\nC-LOOK Number of Head Movements : " + CLOOK(trackRequests, initHeadPos, "right"));
	}

}
