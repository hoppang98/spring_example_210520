package com.example.lesson04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/lesson04")
@Controller 
public class NewUserController {
	
	// 요청 URL : http://localhost/lesson04/ex01/1
	@RequestMapping(method = RequestMethod.GET, path = "/ex01/1") // get만 받겠다
	// @GetMapping("/ex01/1")  위와 동일한 효과
	public String ex01_1() {
		return "lesson04/addUser"; // @Controller로 인해 application.properties파일에서 prefix, suffix를 찾아 간단하게 표현 가능
	}
	
	// 요청 URL : http://localhost/lesson04/ex01/add_user - url를 직접 치고 들어가는 방식은 get방식이라 치고 들어가면 오류가 나온다, 위에서 넘어가야함
	// @RequestMapping(method = RequestMethod.POST, path = "/ex01/add_user")
	@PostMapping("/ex01/add_user") // 위와 동일한 효과
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value = "introduce", required=false) String introduce) { // 비필수 parameter
		
		// DB Insert
		
		
		return "lesson04/afterAddUser";
	}
}
