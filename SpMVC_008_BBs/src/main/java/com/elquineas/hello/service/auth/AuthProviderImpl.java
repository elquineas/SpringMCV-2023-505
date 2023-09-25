package com.elquineas.hello.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("authProviderImpl")
public class AuthProviderImpl implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// authentication 으로 login 할때 입력한 데이터를 호출한다
		String username = (String)authentication.getPrincipal(); // ID 추출
		String password = (String)authentication.getCredentials(); // PW 추출

		log.debug("사용자 정보 : "+authentication.toString());
		log.debug("사용자 이름 : "+username);
		log.debug("사용자 비번 : "+password);
		
		if(!username.equalsIgnoreCase("elquineas")) {
			throw new UsernameNotFoundException(username + "이 없음");
		}
		if(!password.equalsIgnoreCase("1234")) {
			throw new UsernameNotFoundException("비밀번호 오류!");
		}
		
		// 이름과 비밀번호가 일치하면 로그인 실행
		// 정상적인 사용자라면 token 을 발행하고 session에 사용자 정보 등록
		List<GrantedAuthority> grantList = new ArrayList<>();
		
		
		/*
		 * context.xml 에서 권한을 검사할때
		 * hasRole("권한") 처럼 사용한다
		 * Provider 에서 권한을 설정할때는 "ROLE_권한" 과 같은 형식으로 지정을 해주어야 한다.
		 * 다수의 권한을 동시에 부여하여 검사 할 수 있다.
		 */
		grantList.add(new SimpleGrantedAuthority("ROLE_USER"));
//		grantList.add(new SimpleGrantedAuthority("GUEST"));
		grantList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		// 정상적인 사용자임을 증명하는 token 을 발행하여 return
		// security 에게 정상적인 사용자이니 login 절차를 마무리하라는 의미
		return new UsernamePasswordAuthenticationToken(username, password, grantList);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
