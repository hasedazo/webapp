package com.example.webapp.Filter;


import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.webapp.service.ApiAuthService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ApiAuthFilter extends OncePerRequestFilter {

    
    private final ApiAuthService apiAuthService; // APIキーを検証するサービス
    
    // コンストラクタインジェクション
    public ApiAuthFilter(ApiAuthService apiAuthService) {
        this.apiAuthService = apiAuthService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
    	System.out.println("ApiAuthService: " + apiAuthService);
        // リクエストからAPIキーとクライアントIPアドレスを取得
        //String apiKey = request.getHeader("X-API-KEY");
        //String clientIp = request.getRemoteAddr();
        String apiKey = "10.100.100";
        String clientIp = "abcdefghij";
        String requestUri = request.getRequestURI();


        // APIキーとIPアドレスを使ってDBからレコードを取得
        boolean isValid = apiAuthService.validateApiKey(apiKey, clientIp,requestUri);

        if (isValid) {
            // 認証成功、後続の処理に進む
            filterChain.doFilter(request, response);
        } else {
            // 認証失敗、404エラーを返す
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Invalid API Key or IP address");
        }
    }
}
