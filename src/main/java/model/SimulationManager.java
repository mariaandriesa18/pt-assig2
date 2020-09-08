package model;

import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import javax.swing.SwingWorker;

import view.ViewMarket;

public class SimulationManager implements Runnable{
	
	private volatile Integer continueRunning ;
	private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(4);
	private ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
	private BlockingQueue<Customer> custQ = new LinkedBlockingQueue<Customer>();
	private Integer queueNb ;
	private ViewMarket view;
	private volatile Boolean running = true;
	private volatile Calendar later;
	public SimulationManager(ViewMarket vw) {
		this.view = vw;
	}
	
	public void run(){
		executor.setRemoveOnCancelPolicy(true);
		
		later = Calendar.getInstance();
		later.add(Calendar.SECOND, 30);
		while(running) {
			try {
			ClientProducer producer = new ClientProducer(custQ, view);
			ScheduledFuture<?> pf = ses.scheduleAtFixedRate(producer, 0, 1, TimeUnit.SECONDS);
			
			ClientConsumer consumer1 = new ClientConsumer(1, custQ.take(), view);
			ScheduledFuture<?> cf1 = ses.scheduleAtFixedRate(consumer1, 0, 1, TimeUnit.SECONDS);
			
			ClientConsumer consumer2 = new ClientConsumer(2, custQ.take(), view);
			ScheduledFuture<?> cf2 = ses.scheduleAtFixedRate(consumer2, 1, 1, TimeUnit.SECONDS);
			
			ClientConsumer consumer3 = new ClientConsumer(3, custQ.take(), view);
			ScheduledFuture<?> cf3 = ses.scheduleAtFixedRate(consumer3, 2, 1, TimeUnit.SECONDS);
			System.out.println();
		
			if( Calendar.getInstance().getTime().compareTo(later.getTime()) > 0) {
				pf.cancel(true);
				cf1.cancel(true);
				cf2.cancel(true);
				cf3.cancel(true);
				ses.shutdown();
				running = false;
			}
			}catch (InterruptedException e) {}
		}
	
	}


	
}
