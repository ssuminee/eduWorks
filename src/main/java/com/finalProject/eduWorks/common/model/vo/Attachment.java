package com.finalProject.eduWorks.common.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Attachment {
	
	private int atNo;
	private int atRefBno;
	private String atCategory;
	private String atOriginName;
	private String atChangeName;
	private Date atUploadDate;
	private String atStatus;
	
	// ------- 추가 --------
	private int atCount;
	
}
