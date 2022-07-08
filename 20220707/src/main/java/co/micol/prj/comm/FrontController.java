package co.micol.prj.comm;

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
import co.micol.prj.member.command.AjaxMemberIdCheck;
import co.micol.prj.member.command.MemberJoin;
import co.micol.prj.member.command.MemberJoinForm;
import co.micol.prj.member.command.MemberList;
import co.micol.prj.member.command.MemberLogin;
import co.micol.prj.member.command.MemberLoginForm;
import co.micol.prj.member.command.MemberLogout;

@WebServlet("*.do") // 모든 .do 요청 처리
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 요청과 실행문을 맵핑하기 위함(key 값 호출하면 value 값이 넘어옴 => key값 : String, value값 : Command)
	private HashMap<String, Command> map = new HashMap<>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// 초기화 하는 메소드(Mapping 하는 부분)
		map.put("/main.do", new MainCommand()); // 처음 접속하는 메인 페이지
		map.put("/memberLoginForm.do", new MemberLoginForm()); // 로그인 페이지(로그인 폼 호출) / 파일이름,커맨드명,호출명 일치
		map.put("/memberLogin.do", new MemberLogin()); // 로그인 처리
		map.put("/memberLogout.do", new MemberLogout()); // 로그아웃 처리
		map.put("/memberList.do", new MemberList()); // 회원 목록 보기
		map.put("/memberJoinForm.do", new MemberJoinForm()); // 회원가입 화면
		map.put("/ajaxMemberIdCheck.do", new AjaxMemberIdCheck()); // ajax를 이용한 아이디 중복 체크
		map.put("/memberJoin.do", new MemberJoin()); // 회원가입 처리
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 실행하는 메소드(서비스 해주는 부분)
		request.setCharacterEncoding("utf-8"); // 한글 인코딩
		String uri = request.getRequestURI(); // 요청된 URI 확인
		String contextPath = request.getContextPath(); // 요청된 URI로부터 contextPath 확인
		String page = uri.substring(contextPath.length()); // 실제 요청 페이지 찾기

		Command command = map.get(page); // 실제 수행할 Command를 찾음, new MainCommand();
		String viewPage = command.exec(request, response); // 요청 Command를 수행하고 결과를 받음

		// viewResolve(보여줄 페이지, 돌려줄 페이지)
		if (!viewPage.endsWith(".do") && !viewPage.equals(null)) { // 문자열 끝에 .do가 붙어있지않고 null이 아니면
			// ajax를 처리하는 viewResolve
			if (viewPage.startsWith("ajax:")) { // ajax: <= 단어가 일치한다면
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5)); // ajax:의 길이
				return;
			}
			// 정상적인 view 처리
			viewPage = "WEB-INF/views/" + viewPage + ".jsp"; // 시스템에서 접근가능한 폴더를 더해줌
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response); // 원하는 페이지를 호출해서 전달
		} else {
			response.sendRedirect(viewPage); // .do로 권한 위임
		}
	}

}
