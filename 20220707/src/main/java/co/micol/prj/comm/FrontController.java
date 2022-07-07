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
		map.put("/main.do", new MainCommand()); // 처음 접속하는 페이지
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실행하는 메소드(서비스 해주는 부분)
		request.setCharacterEncoding("utf-8"); // 한글 인코딩
		String uri = request.getRequestURI(); // 요청된 URI 확인
		String contextPath = request.getContextPath(); // 요청된 URI로부터 contextPath 확인
		String page = uri.substring(contextPath.length()); // 실제 요청 페이지 찾기
		
		Command command = map.get(page); // 실제 수행할 Command를 찾음, new MainCommand();
		String viewPage = command.exec(request, response); // 요청 Command를 수행하고 결과를 받음
		
		// viewResolve
		if(!viewPage.endsWith(".do") && !viewPage.equals(null)) { // 문자열 끝에 .do가 붙어있지않고 null이 아니면
			viewPage = "WEB-INF/views/" + viewPage + ".jsp"; // 시스템에서 접근가능한 폴더를 더해줌
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response); // 원하는 페이지를 호출해서 전달
		} else {
			response.sendRedirect(viewPage); // .do로 권한 위임
		}
	}

}
