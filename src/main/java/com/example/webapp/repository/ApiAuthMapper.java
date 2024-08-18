package com.example.webapp.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.webapp.entity.ApiAuth;

@Mapper
public interface ApiAuthMapper {
	
	/**
	 * 指定されたIDに対応する「すること」を取得する
	 */
	ApiAuth findByApiKeyAndCliendIp(@Param("clientIp") String clientIp, @Param("apiKey") String apiKey);

}
