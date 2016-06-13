package com.cyww.mapper;

import com.cyww.model.TestModel;

public interface TestMapper {

	/**
	 * 注意要和Test.xml的方法名对应
	 */
	public TestModel findTestByID(int id);

	/**
	 * 注意要和Test.xml的方法名对应
	 */
	public void addTest(TestModel testModel);

	/**
	 * 注意要和Test.xml的方法名对应
	 */
	public void deleteTest(int id);

	/**
	 * 注意要和Test.xml的方法名对应
	 */
	public void updateTest(TestModel testModel);

}
