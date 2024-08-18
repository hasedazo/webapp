package com.example.webapp.service;

import org.springframework.stereotype.Service;

/**
 * API認証 : サービス実装クラス
 */
@Service
public interface ApiAuthService {
	boolean validateApiKey(String apiKey, String clientIp, String requestURL);
}