package co.micol.prj.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.prj.comm.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.serviceimpl.NoticeServiceImpl;
import co.micol.prj.notice.vo.NoticeVO;

public class AjaxNoticeSearch implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 검색
		NoticeService noticeDao = new NoticeServiceImpl();
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		ObjectMapper mapper = new ObjectMapper();
		String key = request.getParameter("key");
		String val = request.getParameter("val");
		list = noticeDao.noticeSearchList(key, val);
		
		String jsonList = null;
		try {
			jsonList = mapper.writeValueAsString(list); // 객체 json 형식(string)으로 변환
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return "ajax:" + jsonList;
	}

}
