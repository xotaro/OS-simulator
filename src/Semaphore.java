import java.util.ArrayList;

public class Semaphore {
	
 	static int semPrint=1;
 	static int semWrite=1;
 	static int semRead=1;
 	static  int semInput=1;
	static ArrayList<Process> PrintQueue;
	static ArrayList<Process> WriteQueue;
	static ArrayList<Process> ReadQueue;
	static ArrayList<Process> InputQueue;
	static ArrayList<Process> Nxt;
	public Semaphore() {
		PrintQueue =new ArrayList<>();
		WriteQueue =new ArrayList<>();
		ReadQueue = new ArrayList<>();
		InputQueue =new ArrayList<>();
		Nxt =new ArrayList<>();
	}
	public void release(ArrayList<Process> a ) {
		
	}
	
	
	
	public void semPrintWait(Process a) throws InterruptedException {
		int temp = PrintQueue.size();
		int x =0;
		if(semPrint==1) {
			semPrint = 0;
		}
		else {
			System.out.println("Iam  : " + a.processID );
			PrintQueue.add(a);
			a.setProcessState(a, a.status.Waiting);	
		while(PrintQueue.contains(a)) {
			System.out.print("");
			if(semPrint==0)
				continue;
				else {
				semPrint = 0;
				System.out.print("istarted +                        "+ a.processID );
				break;	
				}
		}}
		
		//System.out.print(semPrint);
	}
	
	public void semPrintPost(Process a) {
		if(semPrint==0) {
			semPrint = 1;
			if(PrintQueue.isEmpty()!=true) {
			Nxt.add(PrintQueue.get(0));
			PrintQueue.remove(a);
		}
			}
	}
	
	public void semWriteWait(Process a) throws InterruptedException {
				int x =0;
	if(semWrite==1) {
		semWrite = 0;
	}
	else {
		System.out.println("Iam  : " + a.processID );
		WriteQueue.add(a);
		a.setProcessState(a, a.status.Waiting);	
	while(WriteQueue.contains(a)) {
		System.out.print("");
		if(semWrite==0)
			continue;
			else {
			semWrite = 0;
			System.out.print("istarted : "+ a.processID );
			break;	
			}
	}}
}
public void semWritePost(Process a) {
	if(semWrite==0) {
		semWrite = 1;
		if(WriteQueue.isEmpty()!=true) {
		Nxt.add(WriteQueue.get(0));
		WriteQueue.remove(a);
	}
		}
}
//	
//	
	public void semReadWait(Process a) throws InterruptedException {
int x =0;
if(semRead==1) {
	semRead = 0;
}
else {
	System.out.println("Iam  : " + a.processID );
	ReadQueue.add(a);
		
while(ReadQueue.contains(a)) {
	System.out.print("");
	if(semRead==0)
		continue;
		else {
		semRead = 0;
		System.out.print("istarted : "+ a.processID );
		break;	
		}
}}}

	
	public void semReadPost(Process a) {
if(semRead==0) {
	semRead = 1;
	if(ReadQueue.isEmpty()!=true) {
	Nxt.add(ReadQueue.get(0));
	ReadQueue.remove(a);
}
	}}
//	
	public void semInputWait(Process a) throws InterruptedException {
	
	int x =0;
	if(semInput==1) {
		semInput = 0;
	}
	else {
		System.out.println("Iam  : " + a.processID );
		InputQueue.add(a);
		a.setProcessState(a, a.status.Waiting);		
	while(InputQueue.contains(a)) {
		System.out.print("");
		if(semInput==0)
			continue;
			else {
			semInput = 0;
			System.out.print("istarted :"+ a.processID );
			break;	
			}
	}}
	}
//	
	public void semInputPost(Process a) {
	if(semInput==0) {
		semInput = 1;
		if(InputQueue.isEmpty()!=true) {
		Nxt.add(InputQueue.get(0));
		InputQueue.remove(a);
	}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}