package com.finalProject.eduWorks.administration.model.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {
	
	private int studentNo;
	private String studentName;
	private String studentPhone;
	private String studentEmail;
	private String studentBirth;
	private String studentGender;
	private Date studentEnDate;
	private String classTitle;
}
