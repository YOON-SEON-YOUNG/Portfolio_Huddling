package com.kh.Portfolio_Huddling.member;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MemberDaoIm implements MemberDao {

	private static final String NAMESPACE = "com.kh.mappers.memberMapper";
	
	@Inject
	SqlSession sqlsession;
	
	@Transactional
	@Override
	public void register(MemberVo memberVo) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.insert(NAMESPACE + ".insertMember", memberVo);
		String profile_id = memberVo.getMember_id();
		sqlsession.insert(NAMESPACE + ".insertMemberProfile", profile_id);
	}

	@Override
	public int loginId(MemberVo memberVo) throws Exception {
		// TODO Auto-generated method stub
		
		return (int)sqlsession.selectOne(NAMESPACE + ".selectMemberId", memberVo);
	}

	@Override
	public int loginPw(MemberVo memberVo) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(NAMESPACE + ".selectMemberPw", memberVo);
	}

	@Override
	public MemberVo loginInfo(MemberVo memberVo) throws Exception {
		return sqlsession.selectOne(NAMESPACE + ".selectMemberInfo", memberVo);
	}

	@Override
	public List<MemberVo> memberList(MemberVo memberVo) throws Exception {
		return sqlsession.selectList(NAMESPACE + ".selectMemberList", memberVo);
	}
	

	public void memberRating(MemberVo memberVo) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.update(NAMESPACE + ".updateMemberRating", memberVo);
	}

	@Override
	public List<MemberVo> memberSearch(String search) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlsession.selectList(NAMESPACE + ".selectMemberSearch", search);

}
	
	@Override
	public void Profile_Register(MemberProfileVo profileVo) throws Exception {
		sqlsession.update(NAMESPACE + ".updateMemberProfile", profileVo);
		
	}

	// 프로필 조회 
	@Override
	public MemberProfileVo selectMemberProfileread(String member_id) throws Exception {
		// TODO Auto-generated method stub
		MemberProfileVo profileVo = sqlsession.selectOne(NAMESPACE + ".selectMemberProfile", member_id);
		return profileVo;
	}
	
}
