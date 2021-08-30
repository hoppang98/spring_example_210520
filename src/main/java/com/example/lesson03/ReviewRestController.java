package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController
public class ReviewRestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	
	
	// 요청 url : http://localhost/lesson03/ex01?id=2 id가2인 값의 정보를 받아온다
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			// @RequestParam(value="id") int id // 필수 파라미터 // 아래와 같은 방법
			// @RequestParam(value="id", required=true) int id // 필수 파라미터
			// @RequestParam("id") int id // 필수 파라미터에서 value는 써도 괜찮고 안써도 괜찮다
			// int는 값이 꼭 채워져 있을때. Integer은 값이 null일수도 있을 때
			// @RequestParam(value="id", required=false) Integer id // 비필수 파라미터
			@RequestParam(value="id", required=false, defaultValue="1") int id // 비필수 파라미터, 디폴트 값 1
			) {
		Review review = reviewBO.getReviewById(id);
		return review;
		// 만드는 순서 - RestController -> model(Review) -> bo(ReviewBO) - dao(ReviewDAO, xml과 연결) - mappers(reviewMapper.xml)
	}
	
	
	
	// 요청 url : http://localhost/lesson03/ex02
	@RequestMapping("/lesson03/ex02")
	public String ex02() {
		Review review = new Review();
		review.setStoreId(7);
		review.setMenu("삼겹혼밥세트");
		review.setUserName("신보람");
		review.setPoint(4.5);
		review.setReview("혼자 먹기 적당하네요.");
		
		int rowCount = reviewBO.addReview(review); // controller은 bo에게 요청(BO insert)
		return "성공한 행의 개수는 : " +  rowCount;
	}
	
	// 요청 URL : http://localhost/lesson03/ex02/2
	@RequestMapping("/lesson03/ex02/2")
	public String ex02_2() {
		int rowCount = reviewBO.addReviewAsField(3, "치즈와퍼", "신바다", 5.0, "치즈 와퍼 좋아요!");
		
		return "성공한 행의 개수는 : " + rowCount;
	
	}
}
