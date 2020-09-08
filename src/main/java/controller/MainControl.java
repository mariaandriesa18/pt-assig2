
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SimulationManager;
import view.ViewMarket;

public class MainControl {
	
	public static void main(String[] args) {
		ViewMarket vw = new ViewMarket();
		SimulationManager control = new SimulationManager(vw);
		control.run();
		vw.setVisible(true);
	}
	
	// TO DO: from this start the Simulation Manager thread
	/*private class StartSimulation implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				doInBackground();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
	}*/
}