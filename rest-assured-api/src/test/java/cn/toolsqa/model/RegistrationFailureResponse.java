package cn.toolsqa.model;

import java.io.Serializable;

public class RegistrationFailureResponse implements Serializable {
	private String faultId;
	private String fault;
	public String getFaultId() {
		return faultId;
	}
	public void setFaultId(String faultId) {
		this.faultId = faultId;
	}
	public String getFault() {
		return fault;
	}
	public void setFault(String fault) {
		this.fault = fault;
	}
	
	

}
