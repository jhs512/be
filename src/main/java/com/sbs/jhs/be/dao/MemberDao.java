package com.sbs.jhs.be.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sbs.jhs.be.dto.Member;

@Mapper
public interface MemberDao {
	List<Member> getMembers(Map<String, Object> param);

	Member getMember(@Param("id") int id);

	void join(Map<String, Object> param);

	Member getMemberByLoginId(@Param("loginId") String loginId);
}
