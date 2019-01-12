package communication.ch3;

public class Counter {

	private int		count;
	private boolean	isValueSet;

	public int getCount() {
		if (!isValueSet)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		isValueSet = false;
		notify();
		return count;
	}

	public void setCount(int count) {
		if (isValueSet)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		isValueSet = true;
		this.count = count;
		notify();
	}

}
