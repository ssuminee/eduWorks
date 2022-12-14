package com.finalProject.eduWorks.addressBook.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.finalProject.eduWorks.addressBook.model.vo.Address;
import com.finalProject.eduWorks.addressBook.model.vo.AddressOut;
import com.finalProject.eduWorks.common.model.vo.PageInfo;
import com.finalProject.eduWorks.member.model.vo.Member;

@Repository
public class AddressDao {
	
	/**
	 * 1_1. 공용 주소록에 들어가는 사원 수 조회
	 * @return : 재직중인 사원 수
	 */
	public int selectListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("addressMapper.selectListCount");
	}
	
	/**
	 * 1_2. 공용 주소록에 들어갈 재직중인 사원 목록
	 * @param pi : 페이징 처리
	 * @return : 재직중인 사원 목록이 들어간 ArrayList<Member>
	 */
	public ArrayList<Member> selectAddressList(SqlSessionTemplate sqlSession, PageInfo pi, String range){
		
		int limit = pi.getBoardLimit(); // 조회해야되는 게시글 갯수
		int offset = (pi.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("addressMapper.selectAddressList", range, rowBounds);

	}
	
	/**
	 * 2_1. 개인 주소록 '개인주소록' 번호 조회 (기본페이지)
	 * @param memNo : 로그인한 회원 번호
	 * @return : '개인주소록' 번호
	 */
	public int basicAddressNum(SqlSessionTemplate sqlSession, String memNo) {
		return sqlSession.selectOne("addressMapper.basicAddressNum", memNo);
	}
	
	/**
	 * 2_2. 개인 주소록 그룹 중 등록된 연락처 갯수 조회
	 * @param a : 로그인한 회원 아이디, 개인 주소록 번호
	 * @return : 선택한 개인 주소록 그룹 중 등록된 연락처 갯수
	 */
	public int selectIndivNumCount(SqlSessionTemplate sqlSession, Address a) {
		return sqlSession.selectOne("addressMapper.selectIndivNumCount", a);
	}
	
	/**
	 * 2_3. 개인 주소록 '개인주소록'에 저장된 연락처 목록 조회
	 * @param memNo : 로그인한 회원 번호
	 * @param addNo : 로그인한 회원의 개인 주소록 번호
	 * @return : 조회된 연락처 목록이 담긴 ArrayList<Address>
	 */
	public ArrayList<Address> selectAddIndivList(SqlSessionTemplate sqlSession, PageInfo pi, Address a, String range){
				
		int limit = pi.getBoardLimit(); // 조회해야되는 게시글 갯수
		int offset = (pi.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		HashMap map = new HashMap<>();
		
		map.put("range", range);
		map.put("memNo", a.getMemNo());
		map.put("addNo", a.getAddNo());
		
		return (ArrayList)sqlSession.selectList("addressMapper.selectAddIndivList", map, rowBounds);
		
	}
	
	/**
	 * 2_4. 개인 주소록 카테고리 목록 조회
	 * @param memNo : 로그인한 회원 번호
	 * @return : 등록한 카테고리 목록이 담긴 ArrayList<AddressOut>
	 */
	public ArrayList<AddressOut> selectAddCategory(SqlSessionTemplate sqlSession, Address a){
		return (ArrayList)sqlSession.selectList("addressMapper.selectAddCategory", a);		
	}
	
	/**
	 * 3. 개인 주소록 그룹 추가
	 * @param ado : 로그인한 회원 번호, 추가하고자하는 그룹 명
	 * @return : 그룹 추가 성공 여부가 담긴 int형 변수 (성공 : 1 : 실패 : 0)
	 */
	public int ajaxInsertAddIndiv(SqlSessionTemplate sqlSession, AddressOut ado) {
		return sqlSession.insert("addressMapper.insertAddIndiv", ado);
	}
	
	
	/**
	 * 4. 개인 주소록 그룹 중 선택한 그룹에 연락처 등록
	 * @param a : 연락처 정보
	 * @return : 등록 성공 여부 (성공 : success | 실패 : fail)
	 */
	public int insertAddIndivNum(SqlSessionTemplate sqlSession, Address a) {
		return sqlSession.insert("addressMapper.insertAddIndivNum", a);
	}
	
	/**
	 * 5_1. 개인 주소록 그룹 중 선택한 그룹의 연락처 삭제
	 * @param a : 로그인한 회원, 주소록 그룹 번호
	 * @return : 삭제 성공 여부가 담긴 int형 변수 (성공 : 1 | 실패 : 0)
	 */
	public int deleteAllIndivAddNum(SqlSessionTemplate sqlSession, Address a) {
		return sqlSession.delete("addressMapper.deleteAllIndivAddNum", a);
	}
	
	/**
	 * 5_2. 개인 주소록 그룹 중 선택한 그룹 삭제
	 * @param a : 로그인한 회원, 주소록 그룹 번호
	 * @return : 삭제 성공 여부가 담긴 int형 변수 (성공 : 1 | 실패 : 0)
	 */
	public int deleteIndivAddressBook(SqlSessionTemplate sqlSession, Address a) {
		return sqlSession.delete("addressMapper.deleteIndivAddressBook", a);
	}
	
	/**
	 * 6. 선택한 연락처 삭제 
	 * @param addPerNo : 선택한 연락처 번호
	 * @return : 삭제 성공 여부 (성공 : sucess | 실패 : fail)
	 */
	public int deleteIndivAddNum(SqlSessionTemplate sqlSession, String addPerNo) {
		
		String[] arr = addPerNo.split(","); // 선택한 String값 배열에 담기
		
		return sqlSession.delete("addressMapper.deleteIndivAddNum", arr);
	}
	
	/**
	 * 7_1. 선택한 연락처 정보 조회
	 * @param addPerNo : 선택한 연락처 번호
	 * @return : 선택한 연락처 정보
	 */
	public Address ajaxSelectAddInfo(SqlSessionTemplate sqlSession, String addPerNo) {
		return sqlSession.selectOne("addressMapper.selectAddInfo", addPerNo);
	}
	
	/**
	 * 7_2. 선택한 연락처 정보 수정
	 * @param a : 수정된 연락처 정보
	 * @return : 수정 성공 여부 (성공 : success | 실패 : fail)
	 */
	public int updateIndivAddress(SqlSessionTemplate sqlSession, Address a) {
		return sqlSession.update("addressMapper.updateIndivAddress", a);
	}
	
	/**
	 * 8_1. 연락처 검색시 나오는 연락처 수 조회 (개인 주소록)
	 * @param keyword : 검색어
	 * @param a : 로그인한 회원, 주소록 그룹 번호
	 * @return : 검색시 나오는 연락처 수
	 */
	public int searchIndivCount(SqlSessionTemplate sqlSession, String keyword, Address a) {
		
		HashMap map = new HashMap<>();
		
		map.put("keyword", keyword);
		map.put("memNo", a.getMemNo());
		map.put("addNo", a.getAddNo());
		
		return sqlSession.selectOne("addressMapper.searchIndivCount", map);
	}

	/**
	 * 8_2. 연락처 검색시 나오는 연락처 목록 조회 (개인 주소록)
	 * @param keyword : 검색어
	 * @param a : 로그인한 회원, 주소록 그룹 번호
	 * @return : 검색시 나오는 연락처 목록
	 */
	public ArrayList<Address> searchIndivAdd(SqlSessionTemplate sqlSession, PageInfo pi, String keyword, Address a, String range){
		
		int limit = pi.getBoardLimit(); // 조회해야되는 게시글 갯수
		int offset = (pi.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		HashMap map = new HashMap<>();
		
		map.put("keyword", keyword);
		map.put("memNo", a.getMemNo());
		map.put("addNo", a.getAddNo());
		map.put("range", range);
		
		return (ArrayList)sqlSession.selectList("addressMapper.searchIndivAdd", map, rowBounds);
	}
	
	/**
	 * 8_3. 연락처 검색시 나오는 연락처 수 조회 (전사 주소록)
	 * @param keyword : 검색어
	 * @return : 검색시 나오는 연락처 수
	 */
	public int searchPublicCount(SqlSessionTemplate sqlSession, String keyword) {
		return sqlSession.selectOne("addressMapper.searchPublicCount", keyword);
	}
	
	/**
	 * 8_4. 연락처 검색시 나오는 연락처 목록 조회 (전사 주소록)
	 * @param pi : 페이징
	 * @param keyword : 검색어
	 * @return : 검색시 나오는 연락처 목록
	 */
	public ArrayList<Member> searchPublicAdd(SqlSessionTemplate sqlSession, PageInfo pi, String keyword, String range){
		
		int limit = pi.getBoardLimit(); // 조회해야되는 게시글 갯수
		int offset = (pi.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		HashMap map = new HashMap<>();
		
		map.put("keyword", keyword);
		map.put("range", range);
		
		return (ArrayList)sqlSession.selectList("addressMapper.searchPublicAdd", map, rowBounds);
	}
	
	/**
	 * 9. 개인 연락처 그룹명 수정
	 * @param ad : 수정하고자하는 그룹명, 로그인한 회원 사번, 수정하고자하는 그룹 번호
	 * @return : 그룹명 수정 성공여부
	 */
	public int updateIndivAddGroup(SqlSessionTemplate sqlSession, AddressOut ad) {
		return sqlSession.update("addressMapper.updateIndivAddGroup", ad);
	}
	
}
