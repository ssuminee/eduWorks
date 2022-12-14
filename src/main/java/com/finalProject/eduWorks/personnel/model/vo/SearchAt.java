package com.finalProject.eduWorks.personnel.model.vo;

import java.util.ArrayList;

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
public class SearchAt {
	private String deptCode;
	private String jobCode;
	private String startDate;
	private String endDate;
	private String startTime;
	private String endTime;
	private String reason;
	private String keyword;
	private boolean check1;
	private boolean check2;
	private boolean check3;
	private String userNo;
	private ArrayList<Restdate> list;
}
