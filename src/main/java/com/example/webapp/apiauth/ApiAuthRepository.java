package com.example.webapp.apiauth;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApiAuthRepository {
	
	/**
	 * 指定されたAPIキーに対応するレコードを取得する
	 */
	ApiAuthEntity findByApiKey(@Param("apiKey") String apiKey);

}
