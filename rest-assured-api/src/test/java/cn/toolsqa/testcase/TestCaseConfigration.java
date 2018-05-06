package cn.toolsqa.testcase;

import java.util.ResourceBundle;

public class TestCaseConfigration {
	
 static  ResourceBundle configuration;
     
     static {
    	 try{
	    	  configuration = ResourceBundle.getBundle("configuration");
	         }
	         catch(Exception e){
	             System.out.println(e);
       }
     }
	
	public static Integer getWaitTime(){
		return Integer.valueOf(configuration.getString("WaitTime"));
	}

}
