package com.sbs.jhs.be.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.jhs.be.dto.Member;
import com.sbs.jhs.be.dto.ResultData;
import com.sbs.jhs.be.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping("/usr/member/getMembers")
	@ResponseBody
	public ResultData getMembers(@RequestParam Map<String, Object> param) {
		if (param.get("limit") != null) {
			int limit = Integer.parseInt((String) param.get("limit"));
			param.put("limit", limit);
			param.put("limitFrom", 0);
		}

		if (param.get("page") != null) {
			int page = Integer.parseInt((String) param.get("page"));
			int limit = 10;
			int limitFrom = (page - 1) * limit;
			param.put("limit", limit);
			param.put("limitFrom", limitFrom);
		}

		List<Member> members = memberService.getMembers(param);

		return new ResultData("S-1", String.format("총 %d개의 회원 입니다.", members.size()), "members", members);
	}

	@RequestMapping("/usr/member/getMember")
	@ResponseBody
	public ResultData getMember(int id) {
		Member member = memberService.getMember(id);
		return new ResultData("S-1", String.format("%d번 회원입니다.", id), "member", member);
	}

	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public ResultData doJoin(@RequestParam Map<String, Object> param) {
		int id = memberService.join(param);

		return new ResultData("S-1", "가입되었습니다.", "id", id);
	}

	@RequestMapping("/usr/member/doLogin")
	@ResponseBody
	public ResultData doLogin(String loginId, String loginPw) {
		Member member = memberService.getMemberByLoginId(loginId);

		if (member == null) {
			return new ResultData("F-1", String.format("아이디가 %s인 회원은 존재하지 않습니다.", loginId));
		}

		if (member.getLoginPw().equals(loginPw) == false) {
			return new ResultData("F-2", String.format("비밀번호가 일치하지 않습니다.", loginId));
		}

		return new ResultData("S-1", String.format("%s님 환영합니다.", member.getNickname()), "loginId", loginId, "authKey", member.getAuthKey());
	}
}
