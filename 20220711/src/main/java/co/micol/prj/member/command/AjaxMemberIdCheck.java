package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class AjaxMemberIdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse reponse) {
		// ajax를 이용한 아이디 중복 체크
		MemberService memberDao = new MemberServiceImpl();
		String id = request.getParameter("id");
		boolean b = memberDao.isMemberIdCheck(id); // true = 사용가능
		String result = "Used";
		if(!b) { // false
			result = "UnUsed";
		}
		return "ajax:" + result; // 결과가 ajax 호출이라는것을 viewResolve에게 알려주기 위함
	}

}
