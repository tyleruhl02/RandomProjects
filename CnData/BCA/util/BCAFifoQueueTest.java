package HighSchool.CnData.BCA.util;

import java.util.NoSuchElementException;
import java.util.Random;

public class BCAFifoQueueTest {
	public static void main (String args[]) {
		BCAQueue l = new BCAFifoQueue();
		Random rand = new Random(1000);

		long start = System.currentTimeMillis();

		for (int i=0; i<1000000; i++)
			l.enqueue(rand.nextInt());

		l.enqueue(15);
		l.enqueue(18);
		l.enqueue(-16);
		l.enqueue(41);
		l.enqueue(98);
		l.enqueue(1);

		for (int i=0; i<1000000; i++)
			l.enqueue(rand.nextInt());

		if (l.size() == 2000006)
			System.out.println("Passed 1");
		else
			System.out.println("Failed 1");

		for (int i=0; i<1000000; i++)
			l.dequeue();

		if ((Integer)l.peek()==15)
			System.out.println("Passed 2");
		else
			System.out.println("Failed 2");

		if ((Integer)l.dequeue()==15 &&
			(Integer)l.dequeue()==18 &&
			(Integer)l.dequeue()==-16 &&
			(Integer)l.dequeue()==41 &&
			(Integer)l.dequeue()==98 &&
			(Integer)l.dequeue()==1)
			System.out.println("Passed 3");
		else
			System.out.println("Failed 3");

		if (!l.isEmpty())
			System.out.println("Passed 4");
		else
			System.out.println("Failed 4");


		for (int i=0; i<1000000; i++)
			l.dequeue();


		try {
			l.dequeue();
			System.out.println("Failed 5");
		}
		catch (NoSuchElementException ex) {
			System.out.println("Passed 5");
		}


		if(l.peek() != null)
			System.out.println("Failed 6");
		else
			System.out.println("Passed 6");


		if (l.isEmpty())
			System.out.println("Passed 7");
		else
			System.out.println("Failed 7");

		long end = System.currentTimeMillis();
		System.out.printf("Total seconds: %.3f\n", (end-start)/1000.0);
	}
}
