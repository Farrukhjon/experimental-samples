package communication.ch2;

import java.util.concurrent.TimeUnit;

public class MutexDemo {

	public static void main(String[] args) {

		Data mutex = new Data();

		Thread producer = new Thread(new ProducerTask(mutex));
		Thread consumer = new Thread(new ConsumerTask(mutex));
		
		producer.start();
		consumer.start();

		try {
			TimeUnit.SECONDS.sleep(7);
		} catch (InterruptedException e) {
			System.out.println("The main thread has been interrupted");
		}

		producer.interrupt();
		consumer.interrupt();

	}
}