//import java.util.concurrent.Semaphore;


public class Process extends Thread {
	
	public int processID;
    ProcessState status=ProcessState.New;	
    static Semaphore sem;
	
	public Process(int m) {
		sem =new Semaphore();
		processID = m;
	}
	@Override
	public void run() {
		try{
		switch(processID)
		{
		case 1:process1();break;	
		case 2:process2();break;
		case 3:process3();break;
		case 4:process4();break;
		case 5:process5();break;
		}}
		catch (InterruptedException e) {
		//TODO Auto-generated catch block
		e.printStackTrace();
		}}

//	private void process6() throws InterruptedException {
//		int x=0;
//		sem.semPrintWait(this);
//		while (x<301)
//		{ 	
//			OperatingSystem.printText(x+"   666");
//			x++;
//		}
//		sem.semPrintPost(this);
//		setProcessState(this,ProcessState.Terminated);
//		}
		
	
	private void process1() throws InterruptedException {
		setProcessState(this, ProcessState.Running);
		sem.semPrintWait(this);
		OperatingSystem.printText("Enter File Name : ");
		sem.semPrintPost(this);
		sem.semInputWait(this);
		System.out.println("Iam Process 1 NoOne can Take input unless iTake");
		String s=OperatingSystem.TakeInput();
		sem.semInputPost(this);
		sem.semPrintWait(this);
		sem.semReadWait(this);
		System.out.println("Iam Process 1 NoOne can Read  unless iRead");
		OperatingSystem.printText(OperatingSystem.readFile(s));
		sem.semReadPost(this);
		sem.semPrintPost(this);
		setProcessState(this,ProcessState.Terminated);
		}
	
	private void process2() throws InterruptedException {
		setProcessState(this, ProcessState.Running);
		sem.semPrintWait(this);
		OperatingSystem.printText("Enter File Name: ");
		sem.semPrintPost(this);

		sem.semInputWait(this);
		System.out.println("Iam Process 2 NoOne can Take input unless iTake");
		String filename= OperatingSystem.TakeInput();
		sem.semInputPost(this);
		
		sem.semPrintWait(this);
		OperatingSystem.printText("Enter Data: ");
		sem.semPrintPost(this);
		
		sem.semInputWait(this);
		System.out.println("Iam Process 2 NoOne can Take input unless iTake : Data");
		String data= OperatingSystem.TakeInput();
		sem.semInputPost(this);
		
		sem.semWriteWait(this);
		
		OperatingSystem.writefile(filename,data);
		sem.semWritePost(this);
		setProcessState(this,ProcessState.Terminated);
		}
	private void process3() throws InterruptedException {
		setProcessState(this, ProcessState.Running);
		int x=0;
		sem.semPrintWait(this);
		while (x<301)
		{ 	
			OperatingSystem.printText(x+"\n"+"    333");
			x++;
		}
		sem.semPrintPost(this);

		setProcessState(this,ProcessState.Terminated);
		}
	
	private void process4() throws InterruptedException {
	
		int x=500;
		sem.semPrintWait(this);
		while (x<1001)
		{
			OperatingSystem.printText(x+"\n"+"  444");
			x++;
		}	
		sem.semPrintPost(this);
		setProcessState(this,ProcessState.Terminated);
		}
	private void process5() throws InterruptedException {
		setProcessState(this, ProcessState.Running); //to test semaphore 
		sem.semPrintWait(this);
		OperatingSystem.printText("Enter LowerBound: ");
		sem.semPrintPost(this);
		sem.semInputWait(this);
		System.out.println("Iam Process 5 NoOne can Take input unless iTake");
		String lower= OperatingSystem.TakeInput();
		sem.semInputPost(this);
		sem.semPrintWait(this);
		OperatingSystem.printText("Enter UpperBound: ");
		sem.semPrintPost(this);
		sem.semInputWait(this);
		System.out.println("Iam Process 5 NoOne can Take input unless iTake");

		String upper= OperatingSystem.TakeInput();
		sem.semInputPost(this);
		int lowernbr=Integer.parseInt(lower);
		int uppernbr=Integer.parseInt(upper);
		String data="";
		
		while (lowernbr<=uppernbr)
		{
			data+=lowernbr++ +"\n";
			
		}	
		OperatingSystem.writefile("lol.txt" , data);
		setProcessState(this,ProcessState.Terminated);
	}

	 public static void setProcessState(Process p, ProcessState s) {
			p.status = s;
			if (s == ProcessState.Terminated) {
				OperatingSystem.ProcessTable.remove(OperatingSystem.ProcessTable.indexOf(p));
				OperatingSystem.Scheduler.poll(); 
			}
		}
	 public static ProcessState getProcessState(Process p) {
			return p.status;
		}


}