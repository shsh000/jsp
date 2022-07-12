package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse reponse) {
		// 로그인 처리
		HttpSession session = request.getSession(); // 서버가 만들어 놓은 세션을 가져옴
		MemberService memberDao = new MemberServiceImpl(); // 구현체를 통해서 DB 초기화
		MemberVO vo = new MemberVO(); // 사용할 인스턴스 생성
		vo.setMemberId(request.getParameter("memberId")); // memberLoginForm.jsp/input 태그에 있는 name 값
		vo.setMemberPassword(request.getParameter("memberPassword"));
		
		vo = memberDao.memberLogin(vo);
		if(vo.getMemberName() != null) {
			session.setAttribute("id", vo.getMemberId()); // id라는 이름으로 세션에 담음
			session.setAttribute("author", vo.getMemberAuthor()); // author라는 이름으로 세션에 담음
			session.setAttribute("name", vo.getMemberName()); // name이라는 이름으로 세션에 담음
			request.setAttribute("message", vo.getMemberName() + "님 환영합니다."); // 넘겨줄 페이지에 담아줌
		} else {
			request.setAttribute("message", "아이디 또는 패스워드가 일치하지 않습니다.");
		}
		return "member/memberLogin";
	}

}
