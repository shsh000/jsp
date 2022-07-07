package co.micol.prj.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.dept.DeptDAO;

// http://localhost/TestWeb(컨텍스트패스)/empInsert
@WebServlet("/empUpdate")
public class EmpUpdateServ extends HttpServlet {

	// 수정 페이지로 이동
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// DB 조회
		// jobs
		// new EmpDAO() => EmpDAO dao = new EmpDAO();
		EmpDAO empDAO = new EmpDAO();
		DeptDAO deptDAO = new DeptDAO();
		request.setAttribute("jobs", empDAO.selectJobs());
		request.setAttribute("depts", deptDAO.selectAll());
		// 수정할 사번을 받아서 단건 조회
		String employeeID = request.getParameter("employeeID");
		request.setAttribute("emp", empDAO.selectOne(employeeID));
		// 페이지로 이동
		request.getRequestDispatcher("/WEB-INF/jsp/emp/empUpdate.jsp").forward(request, response);

	}

	// 수정처리(doPost())
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 한글인코딩 요청
		response.setContentType("text/html; charset=UTF-8"); // 한글인코딩 응답

		// 파라미터 VO에 담기
		String id = request.getParameter("employeeID");
		String name = request.getParameter("lastName");
		String email = request.getParameter("email");
		String hiredate = request.getParameter("hireDate");
		String jobId = request.getParameter("jobID");
		String deptID = request.getParameter("departmentID");
		EmpVO vo = new EmpVO();
		vo.setEmployeeID(id);
		vo.setLastName(name);
		vo.setEmail(email);
		vo.setHireDate(hiredate);
		vo.setJobID(jobId);
		vo.setDepartmentID(deptID);
		
		EmpDAO empDAO = new EmpDAO();
		int cnt = empDAO.empUpdate(vo);
		
		response.getWriter()
				.append(cnt + "건이 등록됨");
	}
}