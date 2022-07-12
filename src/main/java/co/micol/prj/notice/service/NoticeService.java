package co.micol.prj.notice.service;

import java.util.List;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeService {
	// CRUD
	List<NoticeVO> noticeSelectList(); // 전체 조회 R
	NoticeVO noticeSelect(NoticeVO vo); // 단건 조회 R
	int noticeInsert(NoticeVO vo); // 글등록 C
	int noticeDelete(NoticeVO vo); // 글삭제 U
	int noticeUpdate(NoticeVO vo); // 글수정 D
	
	List<NoticeVO> noticeSearchList(String key, String val); // 목록 검색
	
}
