package site.metacoding.blogv3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // 해당 파일로 시큐리티를 활성화
@Configuration // 설정파일 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    // 인증 설정하는 메서드
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        // super.configure(http); 부모를 가르키는 메서드를 호출하지 않는다. 시큐리티 비활성화
        http.csrf().disable(); // csrf 공격 방어를 해제하기 위한 코드
        http.authorizeRequests()
            .antMatchers("/s/**").authenticated() // /s/**에만 시큐리티를 적용하고
            .anyRequest().permitAll() // 그게 아닌 리퀘스트에는 제외시킨다.
            .and()
            .formLogin() // 폼태그로 로그인할 때
            // .usernameParameter("user") 이렇게 변경 가능
            // .passwordParameter("pwd")
            .loginPage("/login-form") // 해당 페이지로 요청하도록 한다.
            .loginProcessingUrl("/login") // /login 프로세스를 타게 된다.
            .defaultSuccessUrl("/"); // 요청에 성공하면 /로 가게끔 한다.
    }
}
