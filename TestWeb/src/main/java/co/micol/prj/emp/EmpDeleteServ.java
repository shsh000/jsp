package co.micol.prj.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.dept.DeptDAO;

// http://localhost/TestWeb(컨텍스트패스)/empInsert
@WebServlet("/empDelete")
public class EmpDeleteServ extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 한글인코딩 요청
		response.setContentType("text/html; charset=UTF-8"); // 한글인코딩 응답
		
		// 파라미터
		String employeeID = request.getParameter("employeeID");
		
		// DAO -> delete 메서드
		EmpDAO empDAO = new EmpDAO();
		int cnt = empDAO.empDelete(employeeID);

		response.getWriter()
				.append("<script>")
				.append("alert('" + cnt + "건 삭제완료');")
				.append("location.href='empList';")
				.append("</script>");
		// request.setAttribute("msg", cnt + "건 삭제됨");
		// request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}