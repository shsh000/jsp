package co.micol.prj.dept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeptUpdate")
public class DeptUpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 수정 페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터
		String departmentID = request.getParameter("departmentID");
		// 부서번호로 단건조회
		DeptDAO deptDAO = new DeptDAO();
		request.setAttribute("dept", deptDAO.selectOne(departmentID));
		request.getRequestDispatcher("/WEB-INF/jsp/dept/deptUpdate.jsp").forward(request, response);
	}

	// DB 수정처리
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
		DeptDAO deptDAO = new DeptDAO();
		int cnt = deptDAO.deptUpdate(vo);
		
		// 결과 출력
		response.getWriter()
				.append(cnt + "건이 등록됨"); // <form method="post"> 호출할때만 사용가능
	}

}
