package com.stagemate.detail.model.dao;

import static com.stagemate.common.JDBCTemplate.close;
import com.stagemate.detail.model.vo.Detail;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
public class PlayListDao {

   private final Properties sql = new Properties();
   static SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   
   public PlayListDao() {
   String path=PlayListDao.class.getResource("/sql/detail/detail_sql.properties").getPath();
   try {
      sql.load(new FileReader(path));
   } catch (IOException e) {
      e.printStackTrace();
   }

}

   public List<Detail> selectPlayDetail(Connection conn){
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      List<Detail> result=new ArrayList();
      try { 
         pstmt = conn.prepareStatement(sql.getProperty("searchPlayDetail"));
         rs = pstmt.executeQuery();
         while (rs.next()) {
            result.add(getDetailList(rs));
         }

      } catch (SQLException e) {

         e.printStackTrace();

      } finally {

         close(rs);
         close(pstmt);

      }

      return result;
   }
      

   
   public static Detail getDetailList(ResultSet rs) throws SQLException{
      String formattedDate = dateFormat1.format(rs.getDate("RSV_DATE"));
      return Detail.builder()
            .rsvNo(rs.getString("RSV_NO"))
            .eventName(rs.getString("EVENT_NM"))
            .rsvDate(formattedDate)
            .orderStatus(rs.getString("ORDER_STATUS"))
            .build();
   }
   
   private static LocalDateTime getLocalDateTime(ResultSet rs, String columnName) throws SQLException {
        java.sql.Timestamp timestamp = rs.getTimestamp(columnName);
        return (timestamp != null) ? timestamp.toLocalDateTime() : null;
    }
   
   public List<Detail> selectPlayDetailCondition(Connection conn, String userId, String day, String yyyy, String mm, String status, int startRow, int endRow){
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      List<Detail> result = new ArrayList();
      try { 
         String query = sql.getProperty("searchPlayDetail") +
                " WHERE (RSV_DATE >= CASE " +
                "    WHEN '" + day + "' = '1' THEN SYSDATE - INTERVAL '7' DAY " +
                "    WHEN '" + day + "' = '2' THEN SYSDATE - INTERVAL '1' MONTH " +
                "    WHEN '" + day + "' = '3' THEN SYSDATE - INTERVAL '3' MONTH " +
                "END)";
         if (!yyyy.equals("")) {
            query += " AND (TO_CHAR(RSV_DATE, 'YYYY') = '" + yyyy + "')";
         }
         
         if (!mm.equals("")) {
            query += " AND (TO_CHAR(RSV_DATE, 'MM') = '" + mm + "')";
         }
         
         if (!status.equals("전체")) {
            query += " AND (ORDER_STATUS = '" + status + "')";   
         }
         
         query += " AND (MEMBER_ID = '" + userId + "'))";   
         query +=  "WHERE (RN BETWEEN ? AND ?)";

         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, startRow);
         pstmt.setInt(2, endRow);
         
         rs = pstmt.executeQuery();
         while (rs.next()) {
            result.add(getDetailList(rs));
         }

      } catch (SQLException e) {

         e.printStackTrace();

      } finally {

         close(rs);
         close(pstmt);

      }

      return result;
   }
   
   public int selectPlayDetailCount(Connection conn, String userId, String day, String yyyy, String mm, String status) {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      int result= 0;
      try { 
         String query = sql.getProperty("searchPlayDetailCount");

         query +=  " WHERE (RSV_DATE >= CASE "
               + "    WHEN '" + day + "' = '1' THEN SYSDATE - INTERVAL '7' DAY "
               + "    WHEN '" + day + "' = '2' THEN SYSDATE - INTERVAL '1' MONTH "
               + "    WHEN '" + day + "' = '3' THEN SYSDATE - INTERVAL '3' MONTH "
               + "END)";
         if (!yyyy.equals("")) {
            query += " AND (TO_CHAR(RSV_DATE, 'YYYY') = '" + yyyy + "')";
         }
         
         if (!mm.equals("")) {
            query += " AND (TO_CHAR(RSV_DATE, 'MM') = '" + mm + "')";
         }
         
         if (!status.equals("전체")) {
            query += " AND (ORDER_STATUS = '" + status + "')";   
         }
         
         query += " AND (MEMBER_ID = '" + userId + "')";   
         
         pstmt = conn.prepareStatement(query);
         rs = pstmt.executeQuery();
         
         if (rs.next()) {
             result = rs.getInt("row_count");
         }

      } catch (SQLException e) {

         e.printStackTrace();

      } finally {

         close(rs);
         close(pstmt);

      }

      return result;
   }
   
}