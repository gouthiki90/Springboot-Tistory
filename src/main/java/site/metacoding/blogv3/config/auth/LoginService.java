package site.metacoding.blogv3.config.auth;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv3.domain.user.User;
import site.metacoding.blogv3.domain.user.UserRepository;

@RequiredArgsConstructor
@Service // IoC 컨테이너에 등록됨
public class LoginService implements UserDetailsService{ // UserDetailsService타입으로 띄워주어야 한다.

    private final UserRepository userRepository;

    // UsernamePasswordAuthenticationFilter가 호출함
    // IoC컨테이너에서 UserDetatilsService 타입을 찾아서 메서드를 호출한다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username" + username);
        System.out.println("DB에 확인");

        Optional<User> userOp = userRepository.findByUsername(username);

        if(userOp.isPresent()) {
            return new LoginUser(userOp.get()); // Authentication의 principal에 들어감
            // 이게 세션에 들어간다.
        }
        // 필터에는 낚아채지는데 시큐리티에서는 제어가 안 된다.
        // 로그인 틀렸을 때 null 날려서 터지게 된다. 시큐리티에서는 제어가 안 된다.

        return null;
    }
    
}
