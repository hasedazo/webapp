package com.example.webapp.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webapp.entity.ApiAuth;
import com.example.webapp.repository.ApiAuthMapper;
import com.example.webapp.service.ApiAuthService;

@Service
public class ApiAuthServiceImpl implements ApiAuthService{
	
	/** DI */
	@Autowired
    private ApiAuthMapper ApiAuthMapper;

    public boolean validateApiKey(String apiKey, String clientIp, String requestURL) {
    	// データ取得
    	System.out.println(apiKey);
    	System.out.println(clientIp);
    	
    	ApiAuth apiauth = ApiAuthMapper.findByApiKeyAndCliendIp(clientIp,apiKey);
    	
    	// データがない場合は認証失敗
    	if(apiauth == null){
    		System.out.println("認証失敗(データなし)");
    		return false;
    	}
    	
    	// 有効期限チェック
    	LocalDateTime startAt= apiauth.getStartAt();
    	LocalDateTime endAt = apiauth.getEndAt();
    	LocalDateTime currentAt = LocalDateTime.now();
    	System.out.println(currentAt);
    	
    	if(currentAt.isBefore(startAt) || currentAt.isAfter(endAt)) {
    		System.out.println("認証失敗(有効期限外)");
    		return false;
    	}
    	
    	System.out.println(requestURL);
    	System.out.println(apiauth);
    	System.out.println("認証成功");
        return true;
    }
}
