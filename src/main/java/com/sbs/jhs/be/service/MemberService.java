package com.sbs.jhs.be.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.jhs.be.dao.MemberDao;
import com.sbs.jhs.be.dto.Member;

@Service
public class MemberService {
	@Autowired
	private MemberDao articleDao;

	public List<Member> getMembers(Map<String, Object> param) {
		return articleDao.getMembers(param);
	}

	public Member getMember(int id) {
		return articleDao.getMember(id);
	}

}
