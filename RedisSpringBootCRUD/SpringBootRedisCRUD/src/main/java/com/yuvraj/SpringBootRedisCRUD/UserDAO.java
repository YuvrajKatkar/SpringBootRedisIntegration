package com.yuvraj.SpringBootRedisCRUD;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	private static final String KEY = "USER";
	
	public User save(User user) {
		 redisTemplate.opsForHash().put(KEY, user.getUserId(), user);
		 return user;
	}
	
	public User get(String userId) {
		User user = (User)redisTemplate.opsForHash().get(KEY, userId);
		return user;
	}
	
	public Map<Object,Object> findAll(){
		return redisTemplate.opsForHash().entries(KEY);
	}
}
