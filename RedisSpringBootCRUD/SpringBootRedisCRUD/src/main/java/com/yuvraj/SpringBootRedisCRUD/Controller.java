package com.yuvraj.SpringBootRedisCRUD;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redisapi")
public class Controller {
	@Autowired
	private UserDAO dao;
	
	@PostMapping("/save")
	public User save(@RequestBody User user) {
		user.setUserId(UUID.randomUUID().toString());
		return dao.save(user);
	}
	@GetMapping("/get")
	public User getUser(@RequestParam String userId) {
		return dao.get(userId);
	}
	@GetMapping("/getAll")
	public Map<Object,Object> getAll(){
		return dao.findAll();
	}

}
