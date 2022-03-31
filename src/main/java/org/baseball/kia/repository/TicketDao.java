package org.baseball.kia.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.baseball.kia.entity.TicketVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<TicketVo> GamelistRevAble() {
		return sqlSession.selectList("ticket.GamelistRevAble");
	}
	

}