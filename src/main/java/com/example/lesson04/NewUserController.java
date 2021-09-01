package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.NewUserBO;
import com.example.lesson04.model.NewUser;

@RequestMapping("/lesson04")
@Controller 
public class NewUserController {
	
	@Autowired
	private NewUserBO newUserBO;
	
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
		newUserBO.addNewUser(name, yyyymmdd, email, introduce);
		
		return "lesson04/afterAddUser";
	}
	
	
	// 마지막에 가입된 사람 하나의 정보를 가지고 온다. - jsp에서 테이블로 뿌리기
	// 요청 url : http://localhost/lesson04/ex01/last_user
	@GetMapping("/ex01/last_user")
	public String getLastUser(Model model) {
		// 마지막에 가입된 사람 하나의 정보를 가지고 온다. select DB
		NewUser user = newUserBO.getLastNewUser();
		
		model.addAttribute("user", user);
		model.addAttribute("title", "회원 정보");
		
		return "lesson04/lastUser"; // 결과 jsp
	}
}
