package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.MainCommand;
import co.micol.prj.comm.Command;
import co.micol.prj.member.command.AjaxMemberIdCheck;
import co.micol.prj.member.command.MemberJoin;
import co.micol.prj.member.command.MemberJoinForm;
import co.micol.prj.member.command.MemberList;
import co.micol.prj.member.command.MemberLogin;
import co.micol.prj.member.command.MemberLoginForm;
import co.micol.prj.member.command.MemberLogout;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<>(); // 자료 구조

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// 요청과 수행할 command 연결
		map.put("/main.do", new MainCommand()); // 처음 접근하는 곳
		map.put("/memberLoginForm.do", new MemberLoginForm()); // 로그인 페이지(로그인 폼 호출) / 파일이름,커맨드명,호출명 일치
		map.put("/memberLogin.do", new MemberLogin()); // 로그인 처리
		map.put("/memberLogout.do", new MemberLogout()); // 로그아웃 처리
		map.put("/memberList.do", new MemberList()); // 회원 목록 보기
		map.put("/memberJoinForm.do", new MemberJoinForm()); // 회원가입 화면
		map.put("/ajaxMemberIdCheck.do", new AjaxMemberIdCheck()); // ajax를 이용한 아이디 중복 체크
		map.put("/memberJoin.do", new MemberJoin()); // 회원가입 처리
	}

	// 요청 분석, 실행하고 결과 리턴
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글 인코딩
		
		// 요청 분석
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length()); // 실제 페이지
		
		// 요청 실행
		Command command = map.get(page);
		String viewPage = command.exec(request, response);
		
		// 보여줄 페이지
		if (!viewPage.endsWith(".do")) {
			if(viewPage.startsWith("ajax:")) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			viewPage = viewPage + ".tiles";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(viewPage); // 권한 위임
		}
	}

}
