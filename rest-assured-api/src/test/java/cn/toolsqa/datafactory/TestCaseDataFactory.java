package cn.toolsqa.datafactory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.dom4j.Attribute;
import org.dom4j.Document;  
import org.dom4j.Element;  
import org.dom4j.io.SAXReader;

import cn.toolsqa.testcase.TestCase;
import cn.toolsqa.testcase.TestSuit;

public class TestCaseDataFactory {
	
	private static String testDataPath ;
	
	
	public static String getTestDataPath () {
		return testDataPath ;
	}

	/**
	 * 测试数据文件为于resources目录或子目录下，相对于resources目录填写文件路径如下：TestCaseData/test_case_data.xml
	 * @param testCasePath
	 */
	public static void setTestDataPath (String testDataPath ) {
		TestCaseDataFactory.testDataPath  = testDataPath;
	}

	
	
	public static TestSuit loadTestSuit() {
		TestSuit testSuit = new TestSuit();
		  try {  
	        	
	        	//如果测试数据路径为空则使用默认测试数据文件
	            if(testDataPath==null){
	            	testDataPath = "TestCaseData/toolsqa_test_case_data.xml";
	            }
	            
	            SAXReader reader = new SAXReader();  
	            // 获取Testcase数据文件 
	            InputStream testCasedDataIn = TestCaseDataFactory.class.getClassLoader().getResourceAsStream(testDataPath);
	            Document doc = reader.read(testCasedDataIn);  
	            
	            //获取根元素
	            Element rootElement =  doc.getRootElement();
	            TestSuit.baseurl = rootElement.attributeValue("baseurl");
	            		
	            return testSuit;  
	        } catch(Exception e) {  
	            throw new RuntimeException(e);  
	        }  
	
	}
	/**
	 * 使用测试用例编号获取对应案例的测试数据
	 * @param caseId 测试案例编号
	 * @return Map  测试案例数据
	 */
	public static TestCase loadDataByCaseId(String testCaseId) { 
		
        try {  
        	
        	//如果测试数据路径为空则使用默认测试数据文件
            if(testDataPath==null){
            	testDataPath = "TestCaseData/test_case_data.xml";
            }
            
            SAXReader reader = new SAXReader();  
            // 获取Testcase数据文件 
            InputStream testCasedDataIn = TestCaseDataFactory.class.getClassLoader().getResourceAsStream(testDataPath);
            Document doc = reader.read(testCasedDataIn);  
           
            //按测试用例ID查询测试用例
            String xpath = "//testcase[@id='" + testCaseId + "']";  
            Element testCaseEle = (Element)doc.selectSingleNode(xpath);  
           
            //测试用例数据Element数据类型转换为TestCase数据类型方便使用
            TestCase testCase = new TestCase();
            if(testCaseEle != null){
            	//获取TestCase属性
            	testCase.setId(testCaseEle.attributeValue("id"));
            	testCase.setName(testCaseEle.attributeValue("name"));
            	
            	//获取前提条件
                Element preconditionEle = testCaseEle.element("precondition");
                Map<String,String> preconditionMap = new HashMap<String,String>();
                if(preconditionEle != null){
             	   for(Iterator<Attribute> i =  preconditionEle.attributeIterator(); i.hasNext();){ 
                		Attribute attribute = (Attribute) i.next();               		
                		preconditionMap.put(attribute.getName(),attribute.getValue());
                   } 
                }
                testCase.setPreconditions(preconditionMap);
            	
               //获取测试数据
               Element testDataEle = testCaseEle.element("testdata");
               Map<String,String> testDataMap = new HashMap<String,String>();
               if(testDataEle != null){
            	   for(Iterator<Attribute> i =  testDataEle.attributeIterator(); i.hasNext();){ 
               		Attribute attribute = (Attribute) i.next();               		
               		testDataMap.put(attribute.getName(),attribute.getValue());
                  } 
               }
               testCase.setTestData(testDataMap);
               
               //获取测试预期
               Element testExpectEle = testCaseEle.element("expect");
               Map<String,String> expectMap = new HashMap<String,String>();
               if (testExpectEle != null) {
            	   for(Iterator<Attribute> i =  testExpectEle.attributeIterator(); i.hasNext();){ 
                  		Attribute attribute = (Attribute) i.next();               		
                  		expectMap.put(attribute.getName(),attribute.getValue());
                     } 
				}
               testCase.setExpects(expectMap);
            }
            
          //获取前提条件
            Element postconditionEle = testCaseEle.element("poscondition");
            Map<String,String> postconditionMap = new HashMap<String,String>();
            if(postconditionEle != null){
         	   for(Iterator<Attribute> i =  postconditionEle.attributeIterator(); i.hasNext();){ 
            		Attribute attribute = (Attribute) i.next();               		
            		postconditionMap.put(attribute.getName(),attribute.getValue());
               } 
            }
            testCase.setPostconditions(postconditionMap);
            
            return testCase;  
        } catch(Exception e) {  
            throw new RuntimeException(e);  
        }  
	} 
	
}
