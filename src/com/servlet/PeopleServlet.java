package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pojo.PageInfo;
import com.service.PeopleService;
import com.service.impl.PagePeopleServiceImpl;

@WebServlet("/page")
public class PeopleServlet extends HttpServlet {
	PeopleService peopleService = new PagePeopleServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pageSizeStr = req.getParameter("pageSize");
		String pageNumStr = req.getParameter("pageNum");
		int pageSize = 2;
		int pageNum = 1;
		if (pageSizeStr != null && !"".equals(pageSizeStr)) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		if (pageNumStr != null && !"".equals(pageNumStr)) {
			pageNum = Integer.parseInt(pageNumStr);
		}
		
		Logger logger = Logger.getLogger(PeopleServlet.class);
		logger.info("------------------------------------");
		
		PageInfo showPage = peopleService.showPage(pageSize, pageNum);
		req.setAttribute("pageInfo", showPage);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
