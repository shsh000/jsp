package co.micol.prj.dept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeptInsert")
public class DeptInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 등록 페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/dept/deptInsert.jsp").forward(request, response);
		
//		response.getWriter()
//				.append("get 요청"); // url로 요청 <a href=""> or location.href = ""
	}

	// DB 등록처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 한글인코딩 요청
		response.setContentType("text/html; charset=UTF-8"); // 한글인코딩 응답
		
		// 파라미터를 VO에 담기
		String id = request.getParameter("departmentId");
		String name = request.getParameter("departmentName");
		DeptVO vo = new DeptVO();
		vo.setDepartmentId(id);
		vo.setDepartmentName(name);
		
		// DB 등록처리
		DeptDAO dao = new DeptDAO();
		int cnt = dao.deptInsert(vo);
		
		// 결과 출력
		response.getWriter()
				.append(cnt + "건이 등록됨"); // <form method="post"> 호출할때만 사용가능
	}

}
