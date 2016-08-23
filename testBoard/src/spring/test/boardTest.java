package spring.test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import board.dao.boardDAO;
import board.vo.boardVO;


@RunWith(SpringJUnit4ClassRunner.class)//테스트클래스
@ContextConfiguration(locations="classpath:spring/config/beans.xml")//xml매핑
public class boardTest {
	 @Autowired
	   ApplicationContext context;
	 
	 @Autowired
	 boardDAO dao;
	 
	 @Test @Ignore
	 public void init(){
		 DataSource ds= context.getBean("dataSource",DataSource.class);
		  
			try {
				System.out.println(ds.getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			SqlSessionFactory factory=context.getBean("sqlSessionFactory",SqlSessionFactory.class);
			
			System.out.println(factory.getConfiguration());
			   
			
			SqlSession sessoin=context.getBean("sqlSession",SqlSession.class);
			
			System.out.println(sessoin);

	 }
	 
	 @Test @Ignore
	 public void selectAll(){
		 List<boardVO> list=dao.AllList();
		 
		 for (boardVO boardVO : list) {
			System.out.println(boardVO);
		}
	 }
	 
	 @Test @Ignore
	 public void selectone(){
		 boardVO vo=dao.selectOne(1);
		 
		 System.out.println(vo);
	
	 }
	 @Test @Ignore
	 public void insert(){
		 
		 int cnt=dao.insertItem(new boardVO("테스트", "테스트 확인", "1234","제목"));		 
		 System.out.println(cnt);
	
	 }
	 
	 @Test @Ignore
	 public void delete(){
		 int cnt=dao.deleteItem(1);
		 System.out.println(cnt);
	 }
	 
	 @Test @Ignore
	 public void update(){
		 int cnt=dao.updateItem(new boardVO(5,"dkdkd","1234","제목"));
		 System.out.println(cnt);
	 }
}
