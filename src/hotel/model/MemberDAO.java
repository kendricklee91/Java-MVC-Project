package hotel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hotel.model.dto.MemberDTO;
import hotel.model.util.DBUtil;

public class MemberDAO
{
	// 모든 회원 검색해서 반환
	public static ArrayList<MemberDTO> getAllMembers() throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MemberDTO> list = null;
		
		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from member");
			
			rset = pstmt.executeQuery();			
			list = new ArrayList<MemberDTO>();
			
			while(rset.next())
			{
				list.add(new MemberDTO(rset.getInt(1), rset.getString(2), rset.getString(3)));
			}
		}
		finally
		{
			DBUtil.close(conn, pstmt, rset);
		}
		return list;
	}
	
	// 특정 회원 ID에 해당하는 '전화번호' 수정
	//public static boolean updateMemberMobile(int memberId, String memberMobile) throws SQLException
	public static boolean updateMemberMobile(MemberDTO updateMember) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = DBUtil.getConnection();			
			pstmt = conn.prepareStatement("update member set member_mobile = ? where member_id = ?");
			
			pstmt.setString(1, updateMember.getMemberMobile());
			pstmt.setInt(2, updateMember.getMemberId());			
			int result = pstmt.executeUpdate();
			
			if(result == 1)
			{
				return true;
			}	
		}
		finally
		{
			DBUtil.close(conn, pstmt);
		}
		return false;
	}
		
	// id로 해당 회원의 정보 반환
	public static MemberDTO getMember(int memberId) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDTO member = null;
		
		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from member where member_id = ?");
			pstmt.setInt(1, memberId);
			rset = pstmt.executeQuery();
			
			if(rset.next())
			{
				member = new MemberDTO(rset.getInt(1), rset.getString(2), rset.getString(3));
			}			
		}
		finally
		{
			DBUtil.close(conn, pstmt, rset);
		}
		return member;
	}
	
	// 신규 회원 추가
	public static boolean addMember(MemberDTO newMember) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		//int result = 0;

		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("insert into member values (?, ?, ?)");
						
			pstmt.setInt(1, newMember.getMemberId());
			pstmt.setString(2, newMember.getMemberName());
			pstmt.setString(3, newMember.getMemberMobile());
			
			int result = pstmt.executeUpdate();
			
			if(result != 0)
			{
				return true;
			}
		}
		finally
		{
			DBUtil.close(conn, pstmt);
		}		
		return false;
	}
	
	// 특정 회원 삭제
	public static boolean deleteMember(int memberId) throws SQLException
	//public static boolean deleteMember(MemberDTO member) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		//int result = 0;
		
		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("delete from member where member_id = ?");
			
			pstmt.setInt(1, memberId);		
			//pstmt.setInt(1, member.getMemberId());
			int result = pstmt.executeUpdate();
			
			if(result == 1)
			{
				return true;
			}
		}
		finally
		{
			DBUtil.close(conn, pstmt);
		}
		return false;
	}
}
