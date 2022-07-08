package co.micol.prj.member.service;

import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberService {
	// CRUD
	List<MemberVO> memberSelectList(); // 멤버 전체 조회 R
	MemberVO memberSelectOne(MemberVO vo); // 멤버 조회 R
	int memberInsert(MemberVO vo); // 멤버 등록 C
	int memberUpdate(MemberVO vo); // 멤버 수정 U
	int memberDelete(MemberVO vo); // 멤버 삭제 D
	
	boolean isMemberIdCheck(String id); // ID 중복 체크, 중복이 있으면 false
	MemberVO memberLogin(MemberVO vo); // 로그인 처리 R
	
}
