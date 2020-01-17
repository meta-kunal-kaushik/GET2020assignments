/**
 * @author Kunal
 * @desc : This assignment is of First Come First Serve (FCFS)
 *        array size is Dynamically taken at run time
 *        Here all the process say n are stored in 2-D array (process[n][5])
 *        where for any process say 'i',
 *        process[i][0]=Arrival time,
 *        process[i][1]=Burst time,
 *        process[i][2]=Waiting time,
 *        process[i][3]=turnAround time,
 *        and process[i][4]=completion time
 *  
 */
public class FCFS {
	
	/**
	 * 
	 * @desc  this method calculates waitingTime for each process
	 * @param  process, 2-D array of int type which stores info. of each process
	 * @return  void
	 */
	public static void waitingTime(int process[][]) {
		for (int index = 0; index < process.length; index++) {
			// waitingTime = turnAroundTime - burstTime
			process[index][2] = process[index][3] - process[index][1];
		}

	}

	/** 
	 * @desc  this method calculates turnAroundTime for each process
	 * @param  process, 2-D array of int type which stores info. of each process
	 * @return  void
	 */
	public static void turnAroundTime(int process[][]) {

		for (int index = 0; index < process.length; index++) {
			// turnAroundtime = completionTime - ArrivalTime
			process[index][3] = process[index][4] - process[index][0]; // turnAroundTime
		}
	}
	/** 
	 * @desc  this method calculates completionTime for each process
	 * @param  process, 2-D array of int type which stores info. of each process
	 * @return  void
	 */
	public static void completionTime(int process[][]) {

		for (int index = 0; index < process.length; index++) {
			if (process[index][0] == 0) // if arrivalTime is 0
			{
				process[index][4] = process[index][0] + process[index][1];
			} else {
				// if arrivalTime of current process > CompletionTime of previous process
				if (process[index][0] > process[index - 1][4])
				{
					// completionTime = arrivalTime + burstTime
					process[index][4] = process[index][0] + process[index][1];
				} else
					// if arrivalTime of current process < CompletionTime of previous process
					// completionTime = completionTime of previous process + burstTime
					process[index][4] = process[index - 1][4]
							+ process[index][1];
			}
		}
	}
	/** 
	 * @desc  this method calculates averageWaitingTime of processes
	 * @param  process, 2-D array of int type which stores info. of each process
	 * @return  double i.e, returns the averageWaitingTime
	 */
	public static double avgWaitingTime(int process[][]) {
		double avgWaitTime = 0;
		for (int index = 0; index < process.length; index++)
			avgWaitTime += process[index][2];
		return (avgWaitTime / process.length); // average Waiting Time
	}
	/**
	 * @desc  this method calculates averageTurnAroundTime of processes
	 * @param  process, 2-D array of int type which stores info. of each process
	 * @return  double i.e, returns averageTurnAroundTime
	 */
	public static double avgTurnAroundTime(int process[][]) {
		double avgTurnAroundTime = 0;
		for (int index = 0; index < process.length; index++)
			avgTurnAroundTime += process[index][3];
		return (avgTurnAroundTime / process.length); // average TurnAroundTime
	}
	/**
	 * @desc    this method displays all the info. for each process
	 * @param   process, 2-D array of int type which stores info. of each process
	 * @return  void
	 */

	public static String display(int process[][]) {
		String str = "Process |\tArivalTime |\tBurstTime |\tWaitingTime |\tTurnAroundTime |\tCompletionTime \n"
				+ "---------------------------------------------------------------------------------------------------\n";

		for (int index = 0; index < process.length; index++) {
			{
				str += "p[" + index + "]\t\t" + process[index][0] + "\t\t"
						+ process[index][1] + "\t\t" + process[index][2]
						+ "\t\t\t" + process[index][3] + "\t\t\t"
						+ process[index][4] + "\n";
			}
		}
		str += "Average Waiting Time : " + FCFS.avgWaitingTime(process)
				+ "\nAverage Turn Around Time : "
				+ FCFS.avgTurnAroundTime(process);
		return str;
	}

}
