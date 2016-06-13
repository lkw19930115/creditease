package com.cyww.model;

public class TestModel {

	private int test_id;
	private String test_name;
	private int test_age;
	private String test_department;
	private String test_worktype;

	public TestModel() {
		super();
	}

	public int getTest_id() {
		return test_id;
	}

	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}

	public String getTest_name() {
		return test_name;
	}

	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}

	public int getTest_age() {
		return test_age;
	}

	public void setTest_age(int test_age) {
		this.test_age = test_age;
	}

	public String getTest_department() {
		return test_department;
	}

	public void setTest_department(String test_department) {
		this.test_department = test_department;
	}

	public String getTest_worktype() {
		return test_worktype;
	}

	public void setTest_worktype(String test_worktype) {
		this.test_worktype = test_worktype;
	}

	@Override
	public String toString() {
		return "TestModel [test_id=" + test_id + ", test_name=" + test_name + ", test_age=" + test_age + ", test_department=" + test_department + ", test_worktype="
				+ test_worktype + "]";
	}
}
