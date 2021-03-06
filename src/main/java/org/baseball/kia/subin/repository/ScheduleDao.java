package org.baseball.kia.subin.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.baseball.kia.subin.entity.CalendarVo;
import org.baseball.kia.subin.entity.ScheduleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("scheduleDao_subin")
public class ScheduleDao {

	@Autowired
	SqlSession sqlSession;
	
	public List<ScheduleVo> selectDateAndTime() { // 라인업 등록에서 조회할 경기 일정
		return sqlSession.selectList("schedule.selectDateAndTime");
	}
	
	public List<Integer> selectGameDate(String gameDate){ // 경기일자별 경기일정코드 조회
		return sqlSession.selectList("schedule.selectGameDate", gameDate);
	}

	public List<CalendarVo> selectScheduleByMonth(String gameMonth) { // 월별 경기일정 조회
		return sqlSession.selectList("schedule.selectScheduleByMonth", gameMonth);
	}

	public ScheduleVo selectScheduleByNo(int scheduleNo) { // 경기번호로 경기 일정 조회
		return sqlSession.selectOne("schedule.selectScheduleByNo", scheduleNo);
	}
}
