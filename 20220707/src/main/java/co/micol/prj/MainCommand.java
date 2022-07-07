package co.micol.prj;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;

public class MainCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse reponse) {
		// 단순히 시작하는 페이지를 보여주는 메소드
		return "main/main"; // main/main.jsp 보여달라는 의미
	}

}
