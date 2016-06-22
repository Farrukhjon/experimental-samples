package interfaces.processDemo;

public class ApplyProcess {

	public void process(IProcess process) {
		System.out.println(process.getName());
	}

	public static void main(String[] args) {
		ApplyProcess apply = new ApplyProcess();
		apply.process(new UpProcess());
		apply.process(new DownProcess());
	}
}
