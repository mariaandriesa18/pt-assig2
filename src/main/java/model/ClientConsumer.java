package model;
import java.util.List;
import java.util.concurrent.*;

import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import view.ViewMarket;

public class ClientConsumer implements Runnable {
	private Integer queueName ; 
	private Customer c ;
	private ViewMarket view;
	private volatile Integer pt ;
	private DefaultListModel<String> qm;
	
	public ClientConsumer(Integer queueName,Customer nc, ViewMarket v) {
		this.c = nc;
		this.queueName = queueName;
		this.view = v;
		
	} 
	
	public void run() {
		if(c.hasArrived()) {
			addtoQ(c.customerFormat());
			
			/*
			 * qm.addElement(c.customerFormat()); view.setModel(queueName, qm);
			 */
			pt = c.getServiceTime();
				
			while(pt  != 0) {
					c.setServiceTime(pt);
					setElem(c.customerFormat());
			
				/*
				 * if(!qm.isEmpty()) { if(qm.firstElement() != null) { qm.setElementAt(
				 * c.customerFormat(), 0 ); } }
				 
						view.setModel(queueName, qm);*/

					pt--;	
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
					}				
				}
			/*
			 * if(!qm.isEmpty()) { qm.removeElementAt(0); } view.setModel(queueName, qm);
			 */
			removeElem();
	
		}
	}
	
	public synchronized Integer addtoQ(String s) {
		view.addToQ(queueName, s );
		return view.getModel(queueName).getSize();
	}

	
	public synchronized void setElem(String s) {
		view.updateQModel(queueName, s);
	}
	/*public synchronized void updateView() {
	
		System.out.println("Q:"+queueName + " "+c.getCustId()+ " is served for " + c.customerFormat());
		 if(qm.getElementAt(0).substring(0,2).compareTo(c.customerFormat().substring(0,2)) == 0) {
			view.updateQModel( queueName, qm.getElementAt(0));
		}else {
			view.addToQ(queueName,c.customerFormat());
			//qm.setElementAt(c.customerFormat(), 0);
		}
	}*/
	
	public synchronized void removeElem() { 	
		System.out.println("Q:"+queueName+" finished client : "+ c.getCustId());// update Log
		view.removeFromModel(queueName);

	}
	
}
