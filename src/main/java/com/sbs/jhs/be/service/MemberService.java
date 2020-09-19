package com.sbs.jhs.be.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.jhs.be.dao.MemberDao;
import com.sbs.jhs.be.dto.Member;
import com.sbs.jhs.be.util.CUtil;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;

	public List<Member> getMembers(Map<String, Object> param) {
		return memberDao.getMembers(param);
	}

	public Member getMember(int id) {
		return memberDao.getMember(id);
	}

	public int join(Map<String, Object> param) {
		String authKey = getNewAuthKey();
		param.put("authKey", authKey);
		
		memberDao.join(param);
		int id = CUtil.getAsInt(param.get("id"));
		return id;
	}

	private String getNewAuthKey() {
		return UUID.randomUUID().toString();
	}

	public Member getMemberByLoginId(String loginId) {
		return memberDao.getMemberByLoginId(loginId);
	}

}
