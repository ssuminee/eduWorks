package com.finalProject.eduWorks.cnsln.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalProject.eduWorks.administration.model.vo.Student;
import com.finalProject.eduWorks.cnsln.model.dao.CnslnDao;
import com.finalProject.eduWorks.cnsln.model.vo.Cnsln;
import com.finalProject.eduWorks.common.model.vo.PageInfo;
import com.finalProject.eduWorks.common.model.vo.Reply;
import com.finalProject.eduWorks.member.model.vo.Member;

@Service
public class CnslnServiceImpl implements CnslnService{
	
	@Autowired
	private CnslnDao cDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public ArrayList<Cnsln> selectCnslnList(String memNo) {
		return cDao.selectCnslnList(sqlSession, memNo);
	}

	@Override
	public int insertCnsln(Cnsln c) {
		return cDao.insertCnsln(sqlSession, c);
	}

	@Override
	public ArrayList<Member> selectMemberList(String keyword, String memNo) {
		return cDao.selectMemberList(sqlSession, keyword, memNo);
	}

	@Override
	public Member selectMember(String memNo) {
		return cDao.selectMember(sqlSession, memNo);
	}

	@Override
	public Cnsln selectCnsln(int cNo) {
		return cDao.selectCnsln(sqlSession, cNo);
	}

	@Override
	public int increaseCount(int cNo) {
		return cDao.increaseCount(sqlSession, cNo);
	}

	@Override
	public int updateCnsln(Cnsln c) {
		return cDao.updateCnsln(sqlSession, c);
	}

	@Override
	public int deleteCnsln(int cNo) {
		return cDao.deleteCnsln(sqlSession, cNo);
	}

	@Override
	public ArrayList<Reply> selectReplyList(int cNo) {
		return cDao.selectReplyList(sqlSession, cNo);
	}

	@Override
	public int insertReply(Reply r) {
		return cDao.insertReply(sqlSession, r);
	}

	@Override
	public int updateReply(Reply r) {
		return cDao.updateReply(sqlSession, r);
	}

	@Override
	public Reply selectReply(int replyNo) {
		return cDao.selectReply(sqlSession, replyNo);
	}

	@Override
	public int deleteReply(int replyNo) {
		return cDao.deleteReply(sqlSession, replyNo);
	}

	@Override
	public int selectListCount(String keyword, int cate) {
		return cDao.selectListCount(sqlSession, keyword, cate);
	}

	@Override
	public ArrayList<Cnsln> selectCnslnList(PageInfo pi, String keyword, int cate) {
		return cDao.selectCnslnList(sqlSession, pi, keyword, cate);
	}

	@Override
	public int deleteReCnsln(int cNo) {
		return cDao.deleteReCnsln(sqlSession, cNo);
	}

	@Override
	public ArrayList<Student> selectStudentList(String key) {
		return cDao.selectStudentList(sqlSession, key);
	}

	@Override
	public Student selectStudent(int sNo) {
		return cDao.selectStudent(sqlSession, sNo);
	}

	@Override
	public int insertStudent(Student s) {
		return cDao.insertStudent(sqlSession, s);
	}

	@Override
	public int updateStudent(Student s) {
		return cDao.updateStudent(sqlSession, s);
	}
	
	

}
