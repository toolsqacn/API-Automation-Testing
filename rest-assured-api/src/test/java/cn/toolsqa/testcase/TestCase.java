package cn.toolsqa.testcase;

import java.util.Map;

public class TestCase {

	private String id;
	
	private String name;
	
	private Map<String,String> preconditions;
	
	private Map<String,String> testData;
	
	private Map<String,String> expects;
	
	private Map<String,String> postconditions;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Map<String, String> getPreconditions() {
		return preconditions;
	}

	public void setPreconditions(Map<String, String> preconditions) {
		this.preconditions = preconditions;
	}

	public Map<String, String> getTestData() {
		return testData;
	}

	public void setTestData(Map<String, String> testData) {
		this.testData = testData;
	}

	public Map<String, String> getExpects() {
		return expects;
	}

	public void setExpects(Map<String, String> expects) {
		this.expects = expects;
	}

	public Map<String, String> getPostconditions() {
		return postconditions;
	}

	public void setPostconditions(Map<String, String> postconditions) {
		this.postconditions = postconditions;
	}

	@Override
	public String toString() {
		return "TestCase [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestCase other = (TestCase) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
