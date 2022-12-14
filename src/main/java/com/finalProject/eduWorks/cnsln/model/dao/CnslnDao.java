package com.finalProject.eduWorks.cnsln.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.finalProject.eduWorks.administration.model.vo.Student;
import com.finalProject.eduWorks.cnsln.model.vo.Cnsln;
import com.finalProject.eduWorks.common.model.vo.PageInfo;
import com.finalProject.eduWorks.common.model.vo.Reply;
import com.finalProject.eduWorks.member.model.vo.Member;

@Repository
public class CnslnDao {
	
	// 상담 일정 리스트 조회
	public ArrayList<Cnsln> selectCnslnList(SqlSessionTemplate sqlSession, String memNo){
		return (ArrayList)sqlSession.selectList("cnslnMapper.selectCnslnList", memNo);
	}
	
	// 상담 일정 등록
	public int insertCnsln(SqlSessionTemplate sqlSession, Cnsln c) {
		return sqlSession.insert("cnslnMapper.insertCnsln", c);
	}
	
	// 담당자 명단 조회
	public ArrayList<Member> selectMemberList(SqlSessionTemplate sqlSession, String keyword, String memNo){
		HashMap<String, String> map = new HashMap<>();
		map.put("memNo", memNo);
		map.put("keyword", keyword);
		return(ArrayList) sqlSession.selectList("cnslnMapper.selectMemberList", map);
	}
	
	// 상담 일정 조회
	public Cnsln selectCnsln(SqlSessionTemplate sqlSession, int cNo) {
		return sqlSession.selectOne("cnslnMapper.selectCnsln", cNo);
	}
	
	// 담당자 조회
	public Member selectMember(SqlSessionTemplate sqlSession, String memNo) {
		return sqlSession.selectOne("cnslnMapper.selectMember", memNo);
	}
	
	// 조회수 증가
	public int increaseCount(SqlSessionTemplate sqlSession, int cNo) {
		return sqlSession.update("cnslnMapper.increaseCount", cNo);
	}
	
	// 상담 일정 수정
	public int updateCnsln(SqlSessionTemplate sqlSession, Cnsln c) {
		return sqlSession.update("cnslnMapper.updateCnsln", c);
	}
	
	// 상담 일정 삭제
	public int deleteCnsln(SqlSessionTemplate sqlSession, int cNo) {
		return sqlSession.update("cnslnMapper.deleteCnsln", cNo);
	}
	
	// 댓글 리스트 조회
	public ArrayList<Reply> selectReplyList(SqlSessionTemplate sqlSession, int cNo){
		return (ArrayList) sqlSession.selectList("cnslnMapper.selectReplyList", cNo);
	}
	
	// 댓글 입력
	public int insertReply(SqlSessionTemplate sqlSession, Reply r) {
		return sqlSession.insert("cnslnMapper.insertReply", r);
	}
	
	// 댓글 수정
	public int updateReply(SqlSessionTemplate sqlSession, Reply r) {
		return sqlSession.update("cnslnMapper.updateReply", r);
	}
	
	// 댓글 조회
	public Reply selectReply(SqlSessionTemplate sqlSession, int replyNo) {
		return sqlSession.selectOne("cnslnMapper.selectReply", replyNo);
	}
	
	// 댓글 삭제
	public int deleteReply(SqlSessionTemplate sqlSession, int replyNo) {
		return sqlSession.update("cnslnMapper.deleteReply", replyNo);
	}
	
	// 상담 내역 조회
	// 게시글 리스트 개수 조회
	public int selectListCount(SqlSessionTemplate sqlSession, String keyword, int cate) {
		String c = Integer.toString(cate);
		HashMap<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("cate", c);
		return sqlSession.selectOne("cnslnMapper.selectListCount", map);
	}
	
	// 게시글 리스트 조회
	public ArrayList<Cnsln> selectCnslnList(SqlSessionTemplate sqlSession, PageInfo pi, String keyword, int cate){
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		String c = Integer.toString(cate);
		HashMap<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("cate", c);
		
		return (ArrayList) sqlSession.selectList("cnslnMapper.selectCnslnReList", map, rowBounds);
	}
	
	// 상담 내역 삭제
	public int deleteReCnsln(SqlSessionTemplate sqlSession, int cNo) {
		return sqlSession.update("cnslnMapper.deleteReCnsln", cNo);
	}
	
	// 학생 리스트 조회
	public ArrayList<Student> selectStudentList(SqlSessionTemplate sqlSession, String key){
		return (ArrayList) sqlSession.selectList("cnslnMapper.selectStudentList", key);
	}
	
	// 학생 조회
	public Student selectStudent(SqlSessionTemplate sqlSession, int sNo) {
		return sqlSession.selectOne("cnslnMapper.selectStudent", sNo);
	}
	
	// 학생 등록
	public int insertStudent(SqlSessionTemplate sqlSession, Student s) {
		return sqlSession.insert("cnslnMapper.insertStudent", s);
	}
	
	// 학생 수정
	public int updateStudent(SqlSessionTemplate sqlSession, Student s) {
		return sqlSession.update("cnslnMapper.updateStudent", s);
	}

}
