package co.micol.prj.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.dept.DeptDAO;

// http://localhost/TestWeb(컨텍스트패스)/empInsert
@WebServlet("/empInsert")
public class EmpInsertServ extends HttpServlet {

	// 등록 페이지로 이동
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// DB 조회
		// jobs
		// new EmpDAO() => EmpDAO dao = new EmpDAO();
		EmpDAO empDao = new EmpDAO();
		DeptDAO deptDao = new DeptDAO();
		request.setAttribute("jobs", empDao.selectJobs());
		request.setAttribute("depts", deptDao.selectAll());
		// 페이지로 이동
		request.getRequestDispatcher("/WEB-INF/jsp/emp/empInsert.jsp").forward(request, response);

	}

	// 등록처리(doPost())
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 한글인코딩 요청
		response.setContentType("text/html; charset=UTF-8"); // 한글인코딩 응답

		// 파라미터 VO에 담기
//		String id = request.getParameter("employeeID");
//		String name = request.getParameter("lastName");
//		String email = request.getParameter("email");
//		String hiredate = request.getParameter("hireDate");
//		String jobId = request.getParameter("jobID");
//		String deptID = request.getParameter("departmentID");
//		EmpVO vo = new EmpVO();
//		vo.setEmployeeID(id);
//		vo.setLastName(name);
//		vo.setEmail(email);
//		vo.setHireDate(hiredate);
//		vo.setJobID(jobId);
//		vo.setDepartmentID(deptID);
		
		// 위 방식과 동일
		EmpVO vo = new EmpVO();
		vo.setEmployeeID(request.getParameter("employeeID"));
		vo.setLastName(request.getParameter("lastName"));
		vo.setEmail(request.getParameter("email"));
		vo.setHireDate(request.getParameter("hireDate"));
		vo.setJobID(request.getParameter("jobID"));
		vo.setDepartmentID(request.getParameter("departmentID"));
		
		// DB 처리
		EmpDAO dao = new EmpDAO();
		int cnt = dao.empInsert(vo);
		
		// 결과출력
		// response.getWriter().append(cnt + "건이 등록됨");
		// request.getRequestDispatcher("empList").forward(request, response);
		response.sendRedirect("empList");
	}
}