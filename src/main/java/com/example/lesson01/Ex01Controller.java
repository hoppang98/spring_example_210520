package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01") // 메소드에 붙은 mapping 먼저 적용
@Controller
public class Ex01Controller {
	
	// String 출력하기
	// 요청 URL : http://localhost/lesson01/ex01/1
	@ResponseBody                 // 리턴되는 값을 HTML Response Body로 보낸다.
	@RequestMapping("/1")    // 주소 매핑 @RequestMapping("/lesson01/ex01/1")에서 /lesson01/ex01을 위로 보냄
	public String printString() {
		String text = "예제 1번<br>문자열을 response body로 보내는 예제";
		return text; // 기본적으로 html로 인식
	}
	
	// 요청 URL : http://localhost/lesson01/ex01/2
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> printMap() { // @ResponseBody위치는 상관없다
		// {"키"=값}
		Map<String, Object> map = new HashMap<>();
		map.put("apple", 4);
		map.put("바나나", 5443);
		map.put("파인애플", 22);
		map.put("포토", 16);
		
		// MessageConverter
		// map을 리턴하면 json으로 나타난다. web starter에 jackson 이라는 라이브러리가 포함되어 있기 때문에
		// @ResponseBody 어노테이션이 있기 때문에 jackson이 동작함
		return map;
	}
}
