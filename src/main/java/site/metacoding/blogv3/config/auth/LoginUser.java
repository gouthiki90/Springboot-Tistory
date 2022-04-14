package site.metacoding.blogv3.config.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import site.metacoding.blogv3.domain.user.User;

@Data
@RequiredArgsConstructor
public class LoginUser implements UserDetails {

    private final User user; // 컴포지션

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return user.getPassowrd();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() { // 계정 만기 5년 되면 만기됨
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // 활동시간 1년 지나면 계정 락걸림
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // 비밀번호 변경
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() { 
        // TODO Auto-generated method stub
        return true;
    }
    
}
