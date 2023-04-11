package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.web.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/***
 * @@EnableWebSecurity : 스프링 시큐리티 설정 활성화
 * @.csrf().disable().headers().frameOptions().disable() : h2-console 화면을 사용하기 위해 해당 옵션을 disable한다.
 * @authorizeRequests : URL별 권한 관리를 설정한다.
 * @antMatcher : 권한 관리 대상을 지정한다. URL, HTTP 메서드별로 관리가 가능하다
 * "/" 등 지정된 URL은 permitAll() 옵션을 통해 전체 열람 권한을 주었고, "/api/v1/**"주소를 가진 API는 USER 권한을 가진 사람만 가능하게 했다.
 * @anyRequest : 설정된 값들 이외에 나머지 URL 등을 나타낸다. 여기서는 authenticate()를 추가하여 나머지 URL들을 모두 인증된 사용자들에게만 허용했다.
 * @logout().logoutSuccessUrl("") : 로그아웃 기능에 대한 여러 설정의 진입점이다. 로그아웃 성공 시, 주소로 이동한다
 * @oauth2Login : OAuth2 로그인 기능에 대한 설정의 진입점
 * @userInfoEndpoint : 로그인 성공 후, 사용자 정보를 가져올 때 설정들을 담당
 * @userService : 로그인 성공 후, 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록한다.(여기서는 customOAuth2UserService)
 * 리소스 서버에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있다.
 */
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() //2
                .and()
                .authorizeRequests() //3
                .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //4
                .anyRequest().authenticated()//5
                .and()
                .logout()
                .logoutSuccessUrl("/")//6
                .and()
                .oauth2Login()//7
                .userInfoEndpoint()//8
                .userService(customOAuth2UserService);//9
    }
}
