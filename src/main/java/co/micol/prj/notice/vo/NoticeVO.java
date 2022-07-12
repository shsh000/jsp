package co.micol.prj.notice.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int noticeId;
	private String noticeWriter;
	private String noticeTitle;
	private String noticeSubject;
	private Date noticeDate;
	private int noticeHit;
	private String noticeAttach; // 실제 파일명
	private String noticeAttachDir; // 파일 위치명(물리적위치)
}
