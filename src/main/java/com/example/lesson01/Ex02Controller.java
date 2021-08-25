package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 데이터를 내려주는게 아니기 때문에 responseBody 불필요
public class Ex02Controller {
	//요청 URL : http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02")
	public String ex02() {
		// @Controller 어노테이션만 있을 때 (@ResposeBody가 없음)
		// ViewReslover 클래스 작동 -> 리턴된 String이름의 view를 찾아서 view 화면이 구성된다
		return "lesson01/ex02"; // 뷰의 위치에 따른 경로 -> application.properties에서 미리 설정을 했기 때문에 /WEB-INF/jsp 안적어도 된다.
	}
}
