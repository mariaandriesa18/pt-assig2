package model;

public class Customer {
	private Integer custId;
	private Integer arrivalTime;
	private Integer serviceTime;
	private Boolean arrived;
	public Customer() {
	
	}
	public Customer(Customer c) {
		this.custId = c.getCustId();
		this.arrivalTime = c.getArrivalTime();
		this.serviceTime = c.getServiceTime();
		this.arrived = false;
	}
	public Customer(Integer id, Integer arrivT, Integer serviceT) {
		this.arrivalTime = arrivT;
		this.custId = id;
		this.setServiceTime(serviceT);
		this.arrived = false;
	}

	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public Integer getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Integer arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Integer getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(Integer serviceTime) {
		this.serviceTime = serviceTime;
	}
	
	public String customerFormat() {
		String s = this.custId + "-"+ this.arrivalTime +"-"+this.serviceTime;
		return s;
	}
	
	public void customerArrived() {
		this.arrived = true;
	}
	
	public Boolean hasArrived() {
		return this.arrived;
	}
	
}
