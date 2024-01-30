package com.joonfluence.starbucks.global.security;

import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.domain.user.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return customerRepository.findByEmail(email)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(email + " -> 데이터베이스에서 찾을 수 없습니다."));
    }

    // DB 에 User 값이 존재한다면 UserDetails 객체로 만들어서 리턴
    // 해당 사이트는 관리자는 존재하지 않으므로 일반 유저로 고정시킴
    private UserDetails createUserDetails(Customer customer) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(USER_ROLE.ROLE_USER.toString());

        return new User(
                String.valueOf(customer.getId()),
                customer.getPassword(),
                Collections.singleton(grantedAuthority)
        );
    }
}
