package com.service;

import java.io.IOException;

import com.pojo.PageInfo;

public interface PeopleService {
	PageInfo showPage(int pageSize,int pageNum) throws IOException; 

}
