package com.stagemate.detail.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.stagemate.detail.model.vo.Detail;

public class DetailListDao {

	public List<Detail> selectDetails(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Detail> details = new ArrayList();

	}

}
