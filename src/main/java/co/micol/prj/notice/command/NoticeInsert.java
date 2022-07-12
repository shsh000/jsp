package co.micol.prj.notice.command;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.micol.prj.comm.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.serviceimpl.NoticeServiceImpl;
import co.micol.prj.notice.vo.NoticeVO;

public class NoticeInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 등록(파일 업로드 포함)
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		String savePath = "C:\\Temp\\"; // 파일이 저장될 경로(실서버에서는 webapp/fileSave 폴더)
		int uploadSize = 1024*1024*1024; // 최대 파일 사이즈 : 100mb
		int n = 0;
		
		try {
			MultipartRequest multi = new MultipartRequest(request, savePath, uploadSize,
					"utf-8", new DefaultFileRenamePolicy()); // DefaultFileRenamePolicy : 자동으로 파일 이름 변경
			String originalFileName = multi.getOriginalFileName("file");
			String saveFileName = multi.getFilesystemName("file");
			vo.setNoticeWriter(multi.getParameter("noticeWriter"));
			vo.setNoticeTitle(multi.getParameter("noticeTitle"));
			vo.setNoticeDate(Date.valueOf(multi.getParameter("noticeDate")));
			vo.setNoticeSubject(multi.getParameter("noticeSubject"));
			
			if (originalFileName != null) {
				vo.setNoticeAttach(originalFileName);
				saveFileName = savePath + saveFileName; // 파일 경로 추가
				vo.setNoticeAttachDir(saveFileName);
			}
//			System.out.println("================");
//			System.out.println(originalFileName); // 파일 업로드 되는지 확인용
//			System.out.println(saveFileName);
			n = noticeDao.noticeInsert(vo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String returnPage = null;
		if (n != 0) {
			returnPage = "noticeList.do";
		} else {
			request.setAttribute("message", "게시글 등록이 실패했습니다.");
			returnPage = "notice/noticeError";
		}
		return returnPage;
	}

}
