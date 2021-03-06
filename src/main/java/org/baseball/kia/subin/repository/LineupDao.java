package org.baseball.kia.subin.repository;

import org.apache.ibatis.session.SqlSession;
import org.baseball.kia.subin.entity.LineupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("lineupDao_subin")
public class LineupDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public int insertOne(LineupVo vo) { // 라인업 등록
		return sqlSession.insert("lineup.insertOne", vo);
	}
	
	public LineupVo selectOne(int scheduleNo) { // 라인업 조회
		return sqlSession.selectOne("lineup.selectOne", scheduleNo);
	}
	
	public int updateOne(LineupVo vo) { // 라인업 수정
		return sqlSession.update("lineup.updateOne", vo);
	}
}
