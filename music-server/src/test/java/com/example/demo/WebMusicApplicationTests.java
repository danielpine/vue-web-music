package com.example.demo;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Consumer;
import com.example.demo.service.RecommendService;
import com.example.demo.service.SongListService;
import com.example.demo.service.impl.ConsumerServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebMusicApplicationTests {
	@Autowired
	private ConsumerServiceImpl consumerService;

	@Autowired
	private SongListService songListService;
	@Autowired
	private RecommendService recommendService;

	@Test
	public void testRecommendService() {
		recommendService.recommend(1);
	}

	@Test
	public void songListTest2() {
		System.out.println(songListService.likeStyle("乐器"));
	}

	@Test
	public void consumerTest() {
		Consumer consumer = new Consumer();
		consumer.setUsername("test");
		consumer.setPassword("123");
		consumer.setSex(new Byte("0"));
		consumer.setPhoneNum("15666412237");
		consumer.setEmail("1239679@qq.com");
		consumer.setBirth(new Date());
		consumer.setIntroduction("");
		consumer.setLocation("");
		consumer.setAvator("/img/user.jpg");
		consumer.setCreateTime(new Date());
		consumer.setUpdateTime(new Date());
		consumerService.addUser(consumer);
	}
}