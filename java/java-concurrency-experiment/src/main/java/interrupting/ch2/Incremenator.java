package interrupting.ch2;

public class Incremenator extends Thread {

	private volatile boolean	mIsIncrement	= true;

	@Override
	public void run() {
		do {
			if (!Thread.interrupted()) {
				if(mIsIncrement)
					Program.mValue++;			//Инкремент
                else
                	Program.mValue--;			//Декремент
                //Вывод текущего значения переменной
                System.out.print(Program.mValue + " ");
			} else
				return;
			try {
                Thread.sleep(1000);		//Приостановка потока на 1 сек.
            }catch(InterruptedException e){
                return;	//Завершение потока после прерывания
            }
		} while (true);
	}

	// Меняет действие на противоположное
	public void changeAction() {
		mIsIncrement = !mIsIncrement;
	}

}
