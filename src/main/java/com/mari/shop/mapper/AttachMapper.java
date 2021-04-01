package com.mari.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mari.shop.domain.Attach;

@Mapper
public interface AttachMapper {
	
	public int insert(List<Attach> attaches);
}
