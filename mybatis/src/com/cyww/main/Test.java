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
	 * ����
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
	 * ����
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
	 * ɾ��
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
	 * ����
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
		test1.setTest_name("����");
		test1.setTest_age(23);
		test1.setTest_department("cpyb");
		test1.setTest_worktype("kfgcs");
		
		TestModel test2=new TestModel();
		test2.setTest_name("����");
		test2.setTest_age(30);
		test2.setTest_department("��Ʒ����");
		test2.setTest_worktype("���Թ���ʦ");
		
		TestModel test3=new TestModel();
		test3.setTest_name("С��");
		test3.setTest_age(22);
		test3.setTest_department("��Ʒ����");
		test3.setTest_worktype("���ݷ���ʦ");
		
		
		TestModel test4=new TestModel();
		test4.setTest_name("����");
		test4.setTest_age(22);
		test4.setTest_department("�ƻᲿ");
		test4.setTest_worktype("������Ա");

		//����
     	addTest(test1);
     	addTest(test2);
     	addTest(test3);
     	addTest(test4);
     	findTestById(10);
     	//deleteTest(27);
	
//		//����
//		test2.setTest_id(28);
//		test2.setTest_age(21);
//		test2.setTest_department("��Ʒ�Ĳ�");
//		updateTest(test2);

	}
	
}
