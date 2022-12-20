package com.example.demo_movie.configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo_movie.repository.CustomersDao;

@Component
public class TimeCheck {

	@Autowired
	private CustomersDao customerDao;

	@Scheduled(fixedRate = 60000)
	public void timeCheck() {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		//現在的時間減去一分鐘
		LocalDateTime time = LocalDateTime.now().minusMinutes(1);
		customerDao.updateStatus(dateFormat.format(time));
	}
}
