package com.cyww.mapper;

import com.cyww.model.TestModel;

public interface TestMapper {

	/**
	 * ע��Ҫ��Test.xml�ķ�������Ӧ
	 */
	public TestModel findTestByID(int id);

	/**
	 * ע��Ҫ��Test.xml�ķ�������Ӧ
	 */
	public void addTest(TestModel testModel);

	/**
	 * ע��Ҫ��Test.xml�ķ�������Ӧ
	 */
	public void deleteTest(int id);

	/**
	 * ע��Ҫ��Test.xml�ķ�������Ӧ
	 */
	public void updateTest(TestModel testModel);

}
