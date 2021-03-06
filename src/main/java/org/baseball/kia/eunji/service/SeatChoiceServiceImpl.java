package org.baseball.kia.eunji.service;

import java.util.List;

import org.baseball.kia.eunji.entity.SeatChoiceVo;
import org.baseball.kia.eunji.entity.TicketVo;
import org.baseball.kia.eunji.repository.SeatAreaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatChoiceServiceImpl implements SeatChoiceService{
	
	@Autowired
	SeatAreaDao seatAreaDao;
	
	@Override
	public TicketVo selectGame(int no) {
		TicketVo vo = seatAreaDao.selectGame(no);
		return vo;
	}

	@Override
	public List<SeatChoiceVo> seatChoice() {
		List<SeatChoiceVo> list = seatAreaDao.seatChoice();
		return list;
	}
	
	@Override
	public SeatChoiceVo weekPrice(String baseballZone) {
		return seatAreaDao.weekPrice(baseballZone);
	}
	
 
}
