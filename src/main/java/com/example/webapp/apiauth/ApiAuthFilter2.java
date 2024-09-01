package com.example.webapp.apiauth;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ApiAuthFilter2 extends  UsernamePasswordAuthenticationFilter{
	private final AuthenticationManager authenticationManager;
	
	public ApiAuthFilter2(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

        // "/todo/edit/*" の場合に認証を行うよう設定
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/todo/edit/*"));

        // 成功した場合の処理, 今回は取得した person 情報を返しています。
        this.setAuthenticationSuccessHandler((req, res, ex) -> {
            res.setStatus(200);
            MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            res.getWriter().write((new ObjectMapper()).writeValueAsString(user.getPerson()));
        });
    }
	
	@Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        try {
            // リクエストのデータを取り出す
        	// リクエストからAPIキーとクライアントIPアドレスを取得
            //String apiKey = request.getHeader("X-API-KEY");
            //String clientIp = request.getRemoteAddr();
            String apiKey = "abcdefghij";
            String clientIp = "10.100.100";
            String requestUri = request.getRequestURI();
            // 認証処理を実行する
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(apiKey,clientIp)
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
