package com.cyww.main;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.cyww.mapper.TestMapper;
import com.cyww.model.TestModel;

public class Test {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	static {
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查找
	 */
	public static void findTestById(int id) {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			TestMapper testMapper=session.getMapper(TestMapper.class);
			TestModel test = testMapper.findTestByID(id);
			if (test == null)
				System.out.println("null");
			else
				System.out.println(test.toString());
		} finally {
			session.close();
		}
	}
	/**
	 * 增加
	 */
	public static void addTest(TestModel test){
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			TestMapper testMapper = session.getMapper(TestMapper.class);
			testMapper.addTest(test);
            session.commit();  		
		} finally {
			session.close();
		}
		
	}
	/**
	 * 删除
	 * 
	 */
	public static void deleteTest(int id){
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			TestMapper testMapper=session.getMapper(TestMapper.class);
			testMapper.deleteTest(id);
            session.commit();  		
		} finally {
			session.close();
		}
	}
	/**
	 * 更改
	 */
	public static void updateTest(TestModel test){
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession(); 
			TestMapper testMapper=session.getMapper(TestMapper.class);
			testMapper.updateTest(test);
            session.commit();  		
		} finally {
			session.close();
		}
		
	}

	public static void main(String[] args) {							
		TestModel test1 = new TestModel();
		test1.setTest_name("李四");
		test1.setTest_age(23);
		test1.setTest_department("cpyb");
		test1.setTest_worktype("kfgcs");
		
		TestModel test2=new TestModel();
		test2.setTest_name("张三");
		test2.setTest_age(30);
		test2.setTest_department("产品二部");
		test2.setTest_worktype("测试工程师");
		
		TestModel test3=new TestModel();
		test3.setTest_name("小王");
		test3.setTest_age(22);
		test3.setTest_department("产品三部");
		test3.setTest_worktype("数据分析师");
		
		
		TestModel test4=new TestModel();
		test4.setTest_name("明明");
		test4.setTest_age(22);
		test4.setTest_department("财会部");
		test4.setTest_worktype("财务人员");

		//插入
     	addTest(test1);
     	addTest(test2);
     	addTest(test3);
     	addTest(test4);
     	findTestById(10);
     	//deleteTest(27);
	
//		//更改
//		test2.setTest_id(28);
//		test2.setTest_age(21);
//		test2.setTest_department("产品四部");
//		updateTest(test2);

	}
	
}
