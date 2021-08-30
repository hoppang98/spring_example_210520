package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
	public Review selectReviewById(int id); // id값을 넘겨준다 reviewMapper의 `id`옆에 id로
	// public Review selectReviewById(@Param("id") int id); // 넘겨줄 값이 두개 이상이면 키와 값이 있는 map 형태로 만들어야 한다. reviewMapper.xml의 parameterType도 map으로 수정

	public int insertReview(Review review);

	public int insertReviewAsField(
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") double point, 
			@Param("review") String review);
	
}
