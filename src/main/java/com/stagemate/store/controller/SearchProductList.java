package com.stagemate.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.stagemate.store.model.vo.Product;
import com.stagemate.store.model.vo.StoreUpfile;
import com.stagemate.store.service.StoreService;

@WebServlet("/store/productSearch.do")
public class SearchProductList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SearchProductList() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keyword = request.getParameter("search");
        System.out.println(keyword);
        int cPage;
        try {
            cPage = Integer.parseInt(request.getParameter("cPage"));
        } catch (NumberFormatException e) {
            cPage = 1;
        }
        int numPerPage;
        try {
            numPerPage = Integer.parseInt(request.getParameter("numPerpage"));
        } catch (NumberFormatException e) {
            numPerPage = 6;
        }

        List<Product> products = new StoreService().searchProductsByKeyword(cPage, numPerPage, keyword);
        List<StoreUpfile> files=new StoreService().selectAllFile();
        request.setAttribute("products", products);
        request.setAttribute("files", files);

        int totalData = new StoreService().searchProductsByKeywordCnt(keyword);
        int totalPage = (int) Math.ceil((double) totalData / numPerPage);
        int pageBarSize = 3;
        int pageNo = ((cPage - 1) / pageBarSize) * pageBarSize + 1;
        int pageEnd = pageNo + pageBarSize - 1;

        String contextPath = request.getContextPath();
        String pageBar = "";
        // 맨처음 페이지표시
        if (pageNo == 1) {
            pageBar += "<span><img src='" + contextPath + "/images/yoonjin/button/double-arrow-left.svg' alt='arrow-left'></span>";
        } else {
            pageBar += "<a href='" + request.getRequestURI() + "?cPage=" + 1 + "&search=" + keyword
                    + "'><img src='" + contextPath + "/images/yoonjin/button/double-arrow-left.svg' alt='arrow-left'></a>";
        }
        // 이전표시
        if (pageNo == 1) {
            pageBar += "<span><img src='" + contextPath + "/images/yoonjin/button/arrow-left.svg' alt='arrow-left'></span>";
        } else {
            pageBar += "<a href='" + request.getRequestURI() + "?cPage=" + (pageNo - 1) + "&search=" + keyword
                    + "'><img src='" + contextPath + "/images/yoonjin/button/arrow-left.svg' alt='arrow-left'></a>";
        }
        // 선택할 페이지 번호 출력
        while (!(pageNo > pageEnd || pageNo > totalPage)) {
            if (pageNo == cPage) {
                pageBar += "<span>" + pageNo + "</span>";
            } else {
                pageBar += "<a class='bar-num' href='" + request.getRequestURI() + "?cPage=" + pageNo + "&search="
                        + keyword + "'>" + pageNo + "</a>";
            }
            pageNo++;
        }
        // 다음표시
        if (pageNo > totalPage) {
            pageBar += "<span><img src='" + contextPath + "/images/yoonjin/button/arrow-right.svg' alt='arrow-right'></span>";
        } else {
            pageBar += "<a href='" + request.getRequestURI() + "?cPage=" + (pageNo + 1) + "&search=" + keyword
                    + "'><img src='" + contextPath + "/images/yoonjin/button/arrow-right.svg' alt='arrow-right'></a>";
        }
        // 마지막 페이지표시
        if (pageNo > totalPage) {
            pageBar += "<span><img src='" + contextPath + "/images/yoonjin/button/double-arrow-right.svg' alt='arrow-right'></span>";
        } else {
            pageBar += "<a href='" + request.getRequestURI() + "?cPage=" + totalPage + "&search=" + keyword
                    + "'><img src='" + contextPath + "/images/yoonjin/button/double-arrow-right.svg' alt='arrow-right'></a>";
        }

        request.setAttribute("pageBar", pageBar);
        request.getRequestDispatcher("/views/store/productList.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
