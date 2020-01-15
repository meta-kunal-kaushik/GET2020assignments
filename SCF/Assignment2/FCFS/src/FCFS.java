import java.util.Scanner;

/*
 * @author ${kunal kaushik}
 * This assignment is of First Come First Serve (FCFS)
 * array size is Dynamically taken at run time
 * Here all the process say n are stored in 2-D array (process[n][5])
 *where for any process sai 'i',
 * process[i][0]=Arrival time,
 * process[i][1]=Burst time,
 * process[i][2]=Waiting time,
 * process[i][3]=turnAround time,
 * and process[i][0]=completion time
 *  
 */
public class FCFS 
{
	private static Scanner sc = new Scanner(System.in);

	public static void main(String argv[])
	{
		int process[][];
		try{			
			System.out.println("Enter the number of process : ");
			int n=sc.nextInt();//no. of process
			process=new int [n][5]; // dynamic input array
			for(int index=0;index<n;index++)
			{
				System.out.println("Enter the Arrival time for process["+index+"] : ");
				process[index][0]=sc.nextInt(); //ArrivalTime
				System.out.println("Enter the Burst time for process["+index+"] : ");
				process[index][1]=sc.nextInt(); //BurstTime
				System.out.println("..............................................\n");
			}

			FCFS.completionTime(process);
			FCFS.turnAroundTime(process);
			FCFS.waitingTime(process);
			FCFS.display(process);
		}		
		catch(Exception ex) // If invalid input is entered
		{
			System.out.println("Wrong input...\nTry Again..");	
		}
	}







	public static void waitingTime(int process[][])
	{
		for(int index=0;index<process.length;index++)
		{
			//waitingTime = turnAroundTime - burstTime
			process[index][2] = process[index][3]-process[index][1];
		}

	}

	public static void turnAroundTime(int process[][])
	{

		for(int index=0;index<process.length;index++)
		{
			//turnAroundtime = completionTime - ArrivalTime
			process[index][3]=process[index][4]-process[index][0]; //turnAroundTime
		}
	}


	public static void completionTime(int process[][])
	{

		for(int index=0;index<process.length;index++)
		{
			if( process[index][0] == 0) //if arrivalTime is 0
			{	
				process[index][4] = process[index][0] + process[index][1];
			}
			else
			{
				if( process[index][0] > process[index-1][4]) //if arrivalTime of current process > CompletionTime of previous process
				{
					//completionTime = arrivalTime + burstTime
					process[index][4] = process[index][0] + process[index][1]; 
				}
				else //if arrivalTime of current process < CompletionTime of previous process
					//completionTime = completionTime of previous process + burstTime
					process[index][4] = process[index-1][4] + process[index][1];
			}
		}
	}

	public static double avgWaitingTime(int process[][])
	{
		double avgWaitTime=0;
		for(int index=0;index<process.length;index++)
			avgWaitTime+=process[index][2];
		return (avgWaitTime/process.length); //average Waiting Time
	}

	public static double avgTurnAroundTime(int process[][])
	{
		double avgTurnAroundTime=0;
		for(int index=0;index<process.length;index++)
			avgTurnAroundTime+=process[index][3];
		return (avgTurnAroundTime/process.length); //average TurnAroundTime
	}

	public static void display(int process[][])
	{
		System.out.println("Process |\tArivalTime |\tBurstTime |\tWaitingTime |\tTurnAroundTime |\tCompletionTime");
		System.out.println("---------------------------------------------------------------------------------------------------");

		for(int index=0;index<process.length;index++)
		{
			System.out.println("p["+index+"]\t\t"+process[index][0]+"\t\t"+process[index][1]+"\t\t"+process[index][2]+"\t\t\t"+process[index][3]+"\t\t\t"+process[index][4]+"\n");

		}
		System.out.println("Average Waiting Time : " +FCFS.avgWaitingTime(process));
		System.out.println("Average Turn Around Time : " +FCFS.avgTurnAroundTime(process));
	}

}
