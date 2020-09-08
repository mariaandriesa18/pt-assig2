package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ViewMarket extends JFrame{

	private JTextField minArrivTime = new JTextField();
	private JTextField maxArrivTime = new JTextField();
	private JTextField 	minPtTime = new JTextField();
	private JTextField 	maxPtTime = new JTextField();
	private JTextField 	nbOfQs = new JTextField();
	private JTextField simTimeTf = new JTextField();
	private JButton startBtn = new JButton("START");
	
 	private DefaultListModel<String> modelQ1;
	private DefaultListModel<String> modelQ2;
	private DefaultListModel<String> modelQ3;
	private JList<String> list1;
	private JList<String> list2;
	private JList<String> list3;


	public ViewMarket() {
		initialize();
	}
	
	private void initialize() {
		 JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new GridLayout(1,2));
        frame.getContentPane().setBounds(200, 200, 400, 400);
        
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout());
		JPanel p5 = new JPanel();
		p5.setLayout(new FlowLayout());
		
		startBtn.setFont(new Font("Sitka Heading", Font.BOLD, 16));
		startBtn.setBounds(77, 13, 111, 51);
		p1.add(startBtn);	
		
		JLabel lblNewLabel = new JLabel("Arrival Time");
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		p2.add(lblNewLabel, "2, 2, left, top");
		p2.add(minArrivTime, "4, 4, fill, default");
		minArrivTime.setColumns(7);
		p2.add(maxArrivTime, "4, 6, fill, default");
		maxArrivTime.setColumns(7);
		JLabel lblNewLabel_1 = new JLabel("Service Time");
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		p3.add(lblNewLabel_1, "2, 8");
		p3.add(minPtTime);
		minPtTime.setColumns(7);
		p3.add(maxPtTime);
		maxPtTime.setColumns(7);
		
		JLabel lblNewLabel_2 = new JLabel("No of Queues");
		lblNewLabel_2.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		p4.add(lblNewLabel_2, "2, 14");
		p4.add(nbOfQs, "4, 14");
		nbOfQs.setColumns(7);
		
		JLabel lblSimulationTime = new JLabel("Simulation Time");
		lblSimulationTime.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		p5.add(lblSimulationTime, "2, 16, right, default");
		p5.add(simTimeTf, "4, 16, fill, default");
		simTimeTf.setColumns(7);
		
		JPanel sidePanel = new JPanel();
		sidePanel.setPreferredSize(new Dimension(100,400));
		sidePanel.setLayout(new GridLayout(5, 1));
		sidePanel.add(p1);
		sidePanel.add(p2);
		sidePanel.add(p3);
		sidePanel.add(p4);
		sidePanel.add(p5);
		
		JPanel qs= new JPanel();
		qs.setPreferredSize(new Dimension(300, 400));
		qs.setLayout(new GridLayout(1,3));
		
		modelQ1 = setupEmptyModel();
		modelQ2 = setupEmptyModel();
		modelQ3 = setupEmptyModel();
		list1 = new JList<String>(modelQ1);
		//list1.setPreferredSize(new Dimension(100,200));
		JScrollPane sp1 = new JScrollPane(list1);
		qs.add(sp1);
		list2 = new JList<String>(modelQ2);
		//list2.setPreferredSize(new Dimension(100,200));
		JScrollPane sp2 = new JScrollPane(list2);
		qs.add(sp2);
		list3 = new JList<String>(modelQ3);
		//list3.setPreferredSize(new Dimension(100,200));
		JScrollPane sp3 = new JScrollPane(list3);
		qs.add(sp3);
		
		//sidePanel.add(panelQ1);
		frame.getContentPane().add(sidePanel);
		frame.getContentPane().add(qs);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}	

	
	
	public void addStartActionListener(ActionListener startSimulation) {
			this.startBtn.addActionListener(startSimulation);
	}
		
	public String getNbOfQueues() {
		return this.nbOfQs.getText();
	}
	public String getMaxPtTF() {
		return this.maxPtTime.getText();
	}
	public String getMinPtTF() {
		return this.minPtTime.getText();
	}
	
	public String getMaxAtTF() {
		return this.maxArrivTime.getText();
	}
	public String getMinAtTF() {
		return this.minArrivTime.getText();
	}
		
	public String getSimulationTime() {
		return this.simTimeTf.getText();
	}
	public DefaultListModel<String> setupEmptyModel(){
		DefaultListModel<String> m = new DefaultListModel<String>();
		return m;
	}
	public void updateQModel( Integer q, String s) {
		if(q == 1) {
			updateQ1( s);
		}else if(q == 2) {
			updateQ2(s);
		}else if(q==3) {
			updateQ3( s);
		}
	}
	
	public void updateQ1( String s) {
		 for(int i = 0; i < modelQ1.getSize(); i++) {
			 if (modelQ1.get(i).substring(0, 1).contentEquals(s.substring(0,1))) {
				 modelQ1.setElementAt(s, i);
			 }
		 }
	}

public void updateQ2(String s) {
	
	  for(int i = 0; i < modelQ2.getSize(); i++) {
		  if (modelQ2.get(i).substring(0,1).contentEquals(s.substring(0,1))) {
			  modelQ2.setElementAt(s, i);
		  }
	  }
}

public void updateQ3(String s) {
	
	 for(int i = 0; i < modelQ3.getSize(); i++) { 
		 if (modelQ3.get(i).substring(0,1).contentEquals(s.substring(0,1))) {
						modelQ3.setElementAt(s, i);;
			}
	 	}
	 }

	public void addToQ(Integer q, String s) {
		if(q == 1) {
			toQueue1(s);
		}else if(q == 2) {
			toQueue2(s);
		}else if(q == 3){
			toQueue3(s);
		}
	}
	public void copyIntoModel(DefaultListModel<String> s1, DefaultListModel<String>  s2) {
		if(!s1.isEmpty()) {
			for(int i = 0; i < s1.getSize(); i++) {
				for(int j = 0; j < s2.getSize(); i++) {
					s2.setElementAt(s1.getElementAt(i), j);
				}
				
			}
		}
		
	}
	
	public void setModel(Integer qName, DefaultListModel<String> q) {
		if(qName == 1) {
			copyIntoModel(q, modelQ1);
		}else if(qName == 2) {
			copyIntoModel(q, modelQ2);
		}else if(qName == 3) {
			copyIntoModel(q, modelQ3);
		}
	}
	
	public void toQueue1(String s) {
		this.modelQ1.addElement(s);
	}
	
	public void toQueue2(String s) {
		this.modelQ2.addElement(s);
	}
	
	public void toQueue3(String s) {
		this.modelQ3.addElement(s);
	}
	
	public DefaultListModel<String> getModel(int m){
		if(m == 1) {
			return modelQ1;
		}else if(m == 2) {
			return modelQ2;
		}else if( m== 3) {
			return modelQ3;
		}
		return null;
	}
		
	public void removeFromModel(Integer q){
		if(q == 1) {
			removeFromQ1();
		}else if(q == 2) {
			removeFromQ2();
		}else if( q == 3) {
			removeFromQ3();
		}
	}
	public void removeFromQ1() {
		if(!modelQ1.isEmpty()) {
			modelQ1.removeElementAt(0);
		}
	}
	public void removeFromQ2() {
		if(!modelQ2.isEmpty()) {
			modelQ2.removeElementAt(0);
		}
	}
	public void removeFromQ3() {
		if(!modelQ3.isEmpty()) {
			modelQ3.removeElementAt(0);
		}
	}
	
}
