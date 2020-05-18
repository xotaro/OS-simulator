import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.Semaphore;


public class OperatingSystem {
	
	public static ArrayList<Thread> ProcessTable;
	public static Queue<Thread> Scheduler = new LinkedList<Thread>(); 
//	public static int activeProcess= 0;
	//system calls:
	// 1- Read from File
	@SuppressWarnings("unused")
	public static String readFile(String name) {
		String Data="";
		File file = new File(name);
	 try {
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine())
		{
			Data+= scan.nextLine()+"\n";
		}
		scan.close();
	} catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
	}
		return Data;
	}
	
	// 2- Write into file
	@SuppressWarnings("unused")
	public static void writefile(String name, String data) {
		try
		{
			BufferedWriter BW = new BufferedWriter(new FileWriter(name));
			BW.write(data);
			BW.close();
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}

	}
	//3- print to console
	@SuppressWarnings("unused")
	public static void printText(String text) {
        
		System.out.println(text);
		
	}
	
	//4- take input
	
	@SuppressWarnings("unused")
	public static String TakeInput() {
		Scanner in= new Scanner(System.in);
		String data = in.nextLine();
		return data;
		
	}
	          // This one Test SemaPhore
//	private static void createProcess(int processID){
//		Process p = new Process(processID);
//		ProcessTable.add(p);
//		Process.setProcessState(p,ProcessState.Ready);
//		p.start();
//		
//	}
                    // This method Test schedular 
	private static void createProcess(int processID) throws InterruptedException {
		Process p = new Process(processID);
		System.out.println("Process:" + processID + "-> " + p.status);
		ProcessTable.add(p);
		Scheduler.add(p);
		Process.setProcessState(p, ProcessState.Ready);
		System.out.println("Process:" + processID + "-> " + p.status);
		if (Scheduler.size() > 1) {
			while (true) {
				p.sleep(100);
				if (ProcessTable.size() == 1) {
					System.out.println("GO " + "Process:" + processID + "-> " + p.status);
					break;
				}
			}
		}
		p.start();

	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
   		ProcessTable = new ArrayList<Thread>();
//
	createProcess(2);
  //createProcess(6);
  createProcess(1);
	createProcess(3);
		createProcess(4);
	//	createProcess(6); //--> 6 
	createProcess(5);

	}
}



