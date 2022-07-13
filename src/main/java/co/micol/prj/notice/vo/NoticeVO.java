package co.micol.prj.notice.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int noticeId;
	private String noticeWriter;
	private String noticeTitle;
	private String noticeSubject;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date noticeDate;
	private int noticeHit;
	private String noticeAttach; // 실제 파일명
	private String noticeAttachDir; // 파일 위치명(물리적위치)
}
