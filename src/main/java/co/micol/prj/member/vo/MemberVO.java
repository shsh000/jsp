package co.micol.prj.member.vo;

import lombok.Getter;
import lombok.Setter;
// lombok으로 getter, setter 자동 완성

@Getter
@Setter
public class MemberVO {
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberAuthor;
}
