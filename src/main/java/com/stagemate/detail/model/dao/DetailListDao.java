package com.stagemate.detail.model.dao;

import static com.stagemate.common.JDBCTemplate.close;
import com.stagemate.detail.model.vo.Detail;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
public class DetailListDao {

	private final Properties sql = new Properties();
	
	public DetailListDao() {
	String path=DetailListDao.class.getResource("/sql/detail/detail_sql.properties").getPath();
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
		return Detail.builder()
				.rsvNo(rs.getString("RSV_NO"))
				.eventName(rs.getString("EVENT_NAME"))
				.watchDt(rs.getDate("WATCH_DT"))
//				.orderStatus(rs.getString("ORDER_STATUS"))
				.build();
	}
	
}
