package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	// 리뷰 하나를 가져오는데 아이디를 통해서 가져온다 = getReviewById
	public Review getReviewById(int id) {
		return reviewDAO.selectReviewById(id);
	}
	
	public int addReview(Review review) {
		return reviewDAO.insertReview(review);
	}
	
	public int addReviewAsField(int storeId, String menu, String userName, double point, String review) {
		// 3, "치즈와퍼", "신바다", 5.0. "치즈 와퍼 좋아요!"
		return reviewDAO.insertReviewAsField(storeId, menu, userName, point, review);
	}
	
	public int updateReview(int id, String review) {
		return reviewDAO.updateReview(id, review);
	}
	
	public int deleteReviewById(int id) {
		return reviewDAO.deleteReviewById(id);
	}
}
