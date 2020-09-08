package model;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import view.ViewMarket;

public class ClientProducer implements Runnable{
	private BlockingQueue<Customer> custQ = new LinkedBlockingQueue<Customer>();
	private ViewMarket view;
	private Customer newCust;
	private volatile Integer arrT;
	//JText \rea 
	public ClientProducer(BlockingQueue<Customer> q, ViewMarket vw) {
		this.custQ = q; 
		this.view = vw;
	}

	public void run() {
		newCust = RandCustomer.generateCustomer( 1, 4, 2, 15);
		arrT = newCust.getArrivalTime();
		while( arrT != 0) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			arrT--;
			if(arrT == 0) {
				newCust.customerArrived();
			}
			showLog();
		}
		try {
			this.custQ.put(newCust);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}
	
	public synchronized void showLog() {
		System.out.println(newCust.getCustId()+ " arrives in "+ arrT);
	}
	

}
