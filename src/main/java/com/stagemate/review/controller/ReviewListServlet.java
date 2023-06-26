package com.stagemate.review.controller;

import static com.stagemate.common.JDBCTemplate.getConnection; //새로 추가해줘야 하는 임포트. 

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagemate.review.model.vo.EventReview;


@WebServlet("/Review/ReviewListServlet.do")
public class ReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ReviewListServlet() {
        super();

    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// DB conn
		// pstmt 쿼리를 작성
		// rs
		Connection conn=null; 
		PreparedStatement pstmt=null; 
		ResultSet rs=null;
		List<EventReview> list=new ArrayList(); //만들어놓은 Review 클래스에 있는 값만 들어가는 새로운 List를 만드는 것. 
		try {
			conn=getConnection();  //DB 접속
			String sql= "SELECT EVENT_REVIEW_TB.*,MEMBER.MEMBER_NM, EVENT.EVENT_NAME,EVENT_ORDER_TB.WATCH_DT "
					+ "FROM EVENT_REVIEW_TB "
					+ "JOIN MEMBER ON EVENT_REVIEW_TB.MEMBER_ID=MEMBER.MEMBER_ID "
					+ "JOIN EVENT_ORDER_TB ON EVENT_ORDER_TB.RSV_NO=EVENT_REVIEW_TB.RSV_NO "
					+ "JOIN EVENT ON EVENT_ORDER_TB.EVENT_NO=EVENT.EVENT_NO "; //실행할 쿼리
			pstmt=conn.prepareStatement(sql); //실행 준비
			rs=pstmt.executeQuery(); //드디어 쿼리 실행 결과를 rs에 담는다. 
			
			
			while (rs.next()) {
				System.out.println(rs);
				list.add(getReviewList(rs));
			}
		
		 rs.close();
		 pstmt.close();
         conn.close();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
		request.setAttribute("ReviewList", list);
		request.getRequestDispatcher("/views/review/ReviewList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
	
	private EventReview getReviewList(ResultSet rs) throws SQLException{
		return EventReview.builder()
				.eventName(rs.getString("EVENT_NAME"))
				.rpNo(rs.getInt("RP_NO"))
				.rpContent(rs.getString("RP_CONTENT"))
				.rpDate(rs.getDate("RP_DATE"))
				.rsvNo(rs.getString("RSV_NO"))
				.imojiCd(rs.getInt("IMOJI_CD"))
				.memberId(rs.getString("MEMBER_ID"))
				.watchDt(rs.getDate("WATCH_DT"))
				.build(); 
				
	}

}
