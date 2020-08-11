package com.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pojo.PageInfo;
import com.pojo.People;
import com.service.PeopleService;

public class PagePeopleServiceImpl implements PeopleService {

	@Override
	public PageInfo showPage(int pageSize, int pageNum) throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession session = sqlSessionFactory.openSession();

		PageInfo pi = new PageInfo();
		pi.setPageNum(pageNum);
		pi.setPageSize(pageSize);
		
		Map<String, Object> map = new HashMap<>();
		map.put("pageStart", pageSize * (pageNum - 1));
		map.put("pageSize", pageSize);
		List<People> pageInfoList = session.selectList("a.b.selByPage", map);
		pi.setList(pageInfoList);
		
		long count = session.selectOne("a.b.selCount");
		pi.setTotal(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
		return pi;
	}

}
