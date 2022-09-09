package com.scheduler.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.scheduler.document.User;
import com.scheduler.service.SchedulerService;

import lombok.extern.slf4j.Slf4j;

/*
 * Scheduled annotation was used to run
 * a specific task within a certain time
 * interval. The default time unit used
 * in Scheduled was milli-seconds. we can
 * change it to hours, minutes, second by
 * using timeunit attribute.
 */

@Slf4j
@Service
public class SchedulerServiceImpl implements SchedulerService {
	
	@Autowired
	private SchedulerRepository repo;
	
	/*
	 * initalDelay is to delay no of seconds
	 * before the first execution.
	 * fixedRate is for time between each invocation
	 */

	@Override
	@Scheduled(initialDelay = 6000,fixedRate = 5000)
	public void saveUser() {
		int userId = (int) (Math.random()*1000000000);
		User user = new User(userId);
		repo.save(user);
		log.info("User saved Successfully");
	}
	
	/*
	 * In this method time unit was changed from default
	 * milli seconds to minutes.
	 */

	@Override
	//@Scheduled(timeUnit = TimeUnit.MINUTES,fixedRate = 1)
	@Scheduled(cron = "0/10 * * * * *") // Foe every 10 seconds
	public void getAllUsersCount() {
		long usersCount = repo.count();
		log.info("No of Users ="+usersCount);
	}

}
