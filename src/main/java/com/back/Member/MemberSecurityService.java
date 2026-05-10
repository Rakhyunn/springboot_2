package com.back.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberSecurityService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> opMember = memberRepository.findByusername(username);
        if(opMember.isEmpty()){
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        Member member = opMember.get();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if("admin".equals(username)){
            grantedAuthorities.add(new SimpleGrantedAuthority(MemberRole.ADMIN.getRole()));
        } else {
            grantedAuthorities.add(new SimpleGrantedAuthority(MemberRole.USER.getRole()));
        }
        return new User(member.getUsername(), member.getPassword(), grantedAuthorities);
    }
}
