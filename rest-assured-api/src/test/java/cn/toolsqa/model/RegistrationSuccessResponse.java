package cn.toolsqa.model;

import java.io.Serializable;

public class RegistrationSuccessResponse implements Serializable {

		// Variable where value of SuccessCode node
		// will be copied
		// Note: The name should be exactly as the node name is 
		// present in the Json
		private String successCode;
		// Variable where value of Message node will
		// be copied
		// Note: The name should be exactly as the node name is
		// present in the Json
		private String message;
		
		public String getSuccessCode() {
			return successCode;
		}
		public void setSuccessCode(String successCode) {
			this.successCode = successCode;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
		

		
}
