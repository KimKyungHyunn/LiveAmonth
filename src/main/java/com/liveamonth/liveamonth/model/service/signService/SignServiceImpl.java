package com.liveamonth.liveamonth.model.service.signService;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.mapper.signMapper.SignMapper;


@Service
public class SignServiceImpl implements SignService {
	
	@Autowired
	private SignMapper signMapper;

	@Override
	public String checkID(String userID) throws Exception {
		return signMapper.checkID(userID);
	}

	@Override
	public String checkNickName(String userNickName) throws Exception {
		return signMapper.checkNickName(userNickName);
	}

	@Override
	public void insertUser(String userID, String userPassword, String userName, String userNickname, int userAge,
			String userSex, String userEmail) throws Exception {
		UserVO userVO = new UserVO();
		
		userVO.setUserID(userID);
		userVO.setUserPassword(userPassword);
		userVO.setUserName(userName);
		userVO.setUserNickname(userNickname);
		userVO.setUserSex(userSex);
		userVO.setUserAge(userAge);
		userVO.setUserEmail(userEmail);
	
		signMapper.insertUser(userVO);	
	}

	@Override
	public String checkSign(String userID, String userPassword) throws Exception {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("userID", userID);
		hash.put("userPassword", userPassword);
		String userName = signMapper.checkSign(hash);
	
		return userName;
	}

	@Override
	public String findID(String userEmail) throws Exception {
		return signMapper.findID(userEmail);
	}

}
