package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.vo.boardVO;
import board.vo.commentVO;

@Repository("boardDAO")
public class boardDAO {
	
	@Autowired
	SqlSession session;
	
	public List<boardVO> AllList(){

		List<boardVO> list=session.selectList("boardNS.allList");
 		
		return list;
	}
	
	public boardVO selectOne(int id){

		boardVO vo=session.selectOne("boardNS.selectByID",id);
		
		return vo;
		
	}
	
	public List<commentVO> selectComment(int id){
		List<commentVO> list=session.selectList("boardNS.selectComment",id);
		return list;
	}
	
	public String selectPass(int id){
		String pass=session.selectOne("boardNS.selectPass",id);
		return pass;
	}
	
	public int updateItem(boardVO vo){
		int cnt=session.update("boardNS.updateitem",vo);
		return cnt;
	}
	
	public int deleteItem(int id){
		int cnt=session.delete("boardNS.deleteitem",id);
		return cnt;
	}
	
	public int insertItem(boardVO vo){
		int cnt=session.insert("boardNS.insertitem",vo);
		return cnt;
	}
	
	public int insertComment(commentVO vo){
		int cnt=session.insert("boardNS.insertComment",vo);
		return cnt;
	}
}
