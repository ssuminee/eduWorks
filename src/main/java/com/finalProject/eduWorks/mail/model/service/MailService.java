package com.finalProject.eduWorks.mail.model.service;

import java.util.ArrayList;

import com.finalProject.eduWorks.addressBook.model.vo.Address;
import com.finalProject.eduWorks.addressBook.model.vo.AddressOut;
import com.finalProject.eduWorks.common.model.vo.Attachment;
import com.finalProject.eduWorks.common.model.vo.PageInfo;
import com.finalProject.eduWorks.mail.model.vo.Mail;
import com.finalProject.eduWorks.mail.model.vo.MailStatus;
import com.finalProject.eduWorks.member.model.vo.Member;

public interface MailService {

	// 1. 메일 작성 (임시 보관 포함)
	int insertMail(Mail m); // 메일 보내기
	int insertMailStatus(ArrayList<MailStatus> list); // 메일 상태 보내기
	int insertAttachment(ArrayList<Attachment> atList); // 첨부파일 보내기
	
	// 2. 임시저장
	// int insertTemporaryMail(Mail m); // 임시저장 보내기
	
	// 3. 보낸 메일 조회
	int sendListCount(Mail m); // 보낸 메일 개수 조회
	ArrayList<Mail> selectSendMailList(PageInfo pi, Mail m); // 메일 목록 조회
	
	// 3_2. 보낸 메일글 상세조회
	
	// 4. 받은 메일 조회
	int receiveListCount(String memEmail); // 받은 메일 개수 조회
	int receiveUnReadCount(String memEmail); // 받은 메일 중 안읽은 메일 개수 조회
	ArrayList<Mail> selectReceiveMailList(PageInfo pi, String memEmail); // 받은 메일 목록
	
	// 5. 중요메일 설정
	int updateImportant(MailStatus ms);
	
	// 6. 메일 작성시 '주소록에서 찾기'
	ArrayList<Member> selectPublicAddress(); // 전사 주소록
	int selectIndivBasicNum(String memNo); // 개인 주소록 기본번호 찾기
	ArrayList<Address> selectIndivAddress(Address a); // 해당 개인주소록에 등록된 연락처 목록 조회
	ArrayList<AddressOut> selectIndivCategory(Address a); // 개인 주소록 카테고리 목록 조회
	
	// 7. 나에게 보낸 메일 조회
	int sendToMeListCount(Mail m);
	ArrayList<Mail> selectSendToMeMailList(PageInfo pi, Mail m);
	
	// 8. 휴지통 메일 조회
	int deleteListCount(Mail m);
	int deleteUnReadCount(Mail m);
	ArrayList<Mail> selectDeleteMailList(PageInfo pi, Mail m);
	
	// 9. 읽은 메일 조회
	int readListCount(Mail m);
	ArrayList<Mail> selectReadMailList(PageInfo pi, Mail m);
	
	// 10. 안읽은 메일 조회
	int unReadListCount(Mail m);
	ArrayList<Mail> selectUnReadMailList(PageInfo pi, Mail m);
	
	// 11. 중요 메일 조회
	int importantListCount(Mail m);
	int importantUnReadCount(Mail m);
	ArrayList<Mail> selectImportantMailList(PageInfo pi, Mail m);
	

}
