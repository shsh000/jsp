package co.micol.prj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/EmpListServ", "/empList"})
public class EmpListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpListServ() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EmpDAO dao = new EmpDAO();
		request.setAttribute("list", dao.selectAll());
		request.getRequestDispatcher("/WEB-INF/jsp/empList.jsp").forward(request, response);
	}
		
//		// 한글 인코딩
//		response.setContentType("text/html; charset=UTF-8");
//		
//		PrintWriter out = response.getWriter();
//		out.print("<html><body><table><thead><tr><th>사번</th><th>이름</th><th>급여</th></tr></thead>");
//		out.print("<tbody>");
//
//		ArrayList<EmpVO> list = new ArrayList<>();
//		list.add(new EmpVO("100", "mark", "43000")); // 사번, 이름, 급여
//		list.add(new EmpVO("101", "jae", "46000"));
//		list.add(new EmpVO("102", "dy", "50000"));
//
//		for (EmpVO vo : list) {
//			out.print("<tr>");
//			out.printf("<td>%s</td>", vo.getEmployeeID());
//			out.printf("<td>%s</td>", vo.getFirstName());
//			out.printf("<td>%s</td>", vo.getSalary());
//			out.printf("<td>" + vo.getEmployeeID() + "</td>");
//			out.printf("<td>" + vo.getFirstName() + "</td>");
//			out.printf("<td>" + vo.getSalary() + "</td>");
//			out.print("</tr>");
//		}
//		out.print("</tbody></table></body></html>");
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
