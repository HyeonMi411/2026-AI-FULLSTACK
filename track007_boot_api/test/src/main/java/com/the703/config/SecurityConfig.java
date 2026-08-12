package com.the703.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
 
 

@Configuration
@EnableWebSecurity 
@EnableMethodSecurity
public class SecurityConfig { 
	 
	
	// http 경로설정
	@Bean public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http//1. 허용경로
			.authorizeHttpRequests(  auth ->  auth
					.requestMatchers("/users/join"   , "/users/login"  , "/users/iddouble", "/api/util/**").permitAll()
					.requestMatchers("/users/mypage" , "/users/update", "/users/delete"  ).authenticated()
					.anyRequest().permitAll()
			)
			//2. 로그인처리
			.formLogin(form-> form
					.loginPage("/users/login")
					.loginProcessingUrl("/users/loginProc")
					.defaultSuccessUrl("/users/mypage" , true)
					.failureUrl("/users/fail")
					.permitAll()
			)
			//3. 로그아웃
			.logout(logout -> logout
					.logoutUrl("/users/logout")              // 로그아웃 요청 URL (POST)
					.logoutSuccessUrl("/users/login")         // 로그아웃 성공 후 이동할 페이지(로그인페이지)
					.invalidateHttpSession(true)               // 세션 무효화
					.deleteCookies("JSESSIONID")               // 쿠키 삭제
					.clearAuthentication(true)                 // 인증정보 제거
					.permitAll()
			)
			//4. csrf 예외처리
			.csrf(  csrf -> csrf
					.ignoringRequestMatchers("/users/join" , "/users/update" ,  "/users/delete" ));
		return  http.build();
	} 
	
	// AuthenticationManager 설정
	@Bean
	public AuthenticationManager  authenticationManager(AuthenticationConfiguration  config) throws Exception {
		return   config.getAuthenticationManager();
	} 
	
}





