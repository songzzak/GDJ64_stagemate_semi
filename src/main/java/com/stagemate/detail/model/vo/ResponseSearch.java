package com.stagemate.detail.model.vo;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseSearch {
     private int totalCount;
     private List<Detail> detailList;
     private List<StoreDetail> storeList;
     private String pageBar;
}
