package com.stagemate.admin.model.dao;

import static com.stagemate.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.stagemate.common.JDBCTemplate;
import com.stagemate.common.MemberGenerator;
import com.stagemate.member.model.vo.Member;

public class AdminDao {
	private final Properties sql = new Properties();

	public AdminDao() {
		String path = AdminDao.class.getResource("/sql/admin/adminsql.properties").getPath();
		try {
			sql.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Member> memberManage(Connection conn, int cPage, int numPerpage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> members = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("searchMember"));
			pstmt.setInt(1, (cPage - 1) * numPerpage + 1);
			pstmt.setInt(2, cPage * numPerpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member m = MemberGenerator.by(rs);
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return members;
	}

	public int memberCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectMemberCount"));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public int selectMemberCountByType(Connection conn,String keyword, String type) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql=this.sql.getProperty("selectMemberCountByType");
		sql=sql.replace("#COL", type);
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+keyword+"%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	public List<Member> searchMember(Connection conn,String keyword, String type, int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Member> members=new ArrayList<>();
		String sql=this.sql.getProperty("searchMemberByType");
		sql=sql.replace("#COL", type);
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,"%"+keyword+"%");
			pstmt.setInt(2, (cPage-1)*numPerpage+1);
			pstmt.setInt(3, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member m=MemberGenerator.by(rs);
				members.add(m);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return members;
	}
	
	public int outmember(Connection conn,String outid) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("outmember"));
			pstmt.setString(1, outid);
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public static Member getMemberDTO(ResultSet rs) throws SQLException {
		return Member.builder().memberId(rs.getString("MEMBER_ID")).memberPw(rs.getString("MEMBER_PW"))
				.memberNm(rs.getString("MEMBER_NM")).memberBdate(rs.getDate("MEMBER_BDATE"))
				.memberEmail(rs.getString("MEMBER_EMAIL")).memberPhone(rs.getString("MEMBER_PHONE"))
				.memberAddress(rs.getString("MEMBER_ADDRESS")).enrollDate(rs.getDate("ENROLL_DATE"))
				.wthdrDate(rs.getDate("WTHDR_DATE"))
				// .proImgNo(rs.getInt(""))
				.build();
	}

}
