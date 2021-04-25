package com.liveamonth.liveamonth.controller.reviewController;

import com.liveamonth.liveamonth.model.service.reviewService.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewController {
	@Autowired
	private  ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@GetMapping("/review")
	public String hello(Model model) {
		return "reviewView/Review";
	}

}
