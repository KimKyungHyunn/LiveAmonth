package com.liveamonth.liveamonth.model.mapper.reviewMapper;

import com.liveamonth.liveamonth.entity.vo.ReviewVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
@Mapper
public interface ReviewMapper {
    public ArrayList<HashMap<String, Object>> getAllReviewList(HashMap<String, Integer> page) throws Exception;

    public ArrayList<HashMap<String, Object>> getFreeReviewList(HashMap<String, Integer> page)throws Exception;

    public ArrayList<HashMap<String, Object>> getPopularReviewList(HashMap<String, Integer> page)throws Exception;

    public ArrayList<HashMap<String, Object>> getCategoryReviewList(HashMap<String, Object> CategoryAndPage);

    public ReviewVO getReviewVO(int reviewNO) throws Exception;

    public int addReview(ReviewVO reviewVO)throws Exception;

    public int getReviewListCount(String category) throws Exception;
}
