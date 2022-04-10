package org.baseball.kia.yg.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.baseball.kia.yg.entity.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao {
	
	@Autowired
	SqlSession sqlSession;

	public List<CommentVo> readCmt(int boardNo) {
		return sqlSession.selectList("comment.selectAll",boardNo);
	}

	public void addCmt(CommentVo vo) {
		sqlSession.insert("comment.insertOne",vo);
	}

}