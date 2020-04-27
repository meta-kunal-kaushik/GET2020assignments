import java.util.Scanner;
/**
 * 
 * @author : Kunal
 * @desc    : this class uses predefined functions of class FCFS
 * 		  Array size is Dynamically taken at run time,
 *        Here all the process say n are stored in 2-D array (process[n][5])
 *        where for any process say 'i',
 *        process[i][0]=Arrival time,
 *        process[i][1]=Burst time,
 *        process[i][2]=Waiting time,
 *        process[i][3]=turnAround time,
 *        and process[i][4]=completion time   
 */

public class FcfsExecute {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String argv[]) {
		int process[][]; // this array stores the info. of all the processes
		try {
			System.out.println("Enter the number of process : ");
			int n = sc.nextInt();// no. of process
			process = new int[n][5]; // dynamic input array 
			for (int index = 0; index < n; index++) {
				System.out.println("Enter the Arrival time for process["
						+ index + "] : ");
				process[index][0] = sc.nextInt(); // ArrivalTime
				System.out.println("Enter the Burst time for process[" + index
						+ "] : ");
				process[index][1] = sc.nextInt(); // BurstTime
				System.out
						.println("..............................................\n");
			}

			FCFS.completionTime(process);
			FCFS.turnAroundTime(process);
			FCFS.waitingTime(process);
			System.out.println(FCFS.display(process));
		} catch (Exception ex) // If invalid input is entered
		{
			System.out.println("Wrong input...\nTry Again later..");
		}
	}

}
