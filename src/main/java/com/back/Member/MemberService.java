package com.back.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member create(String username, String email, String password) {
        Member member = new Member();
        member.setUsername(username);
        member.setEmail(email);
        member.setPassword(passwordEncoder.encode(password));
        memberRepository.save(member);
        return member;
    }

    public Member findByUsername(String username) {
        Optional<Member> opMember = memberRepository.findByusername(username);
        if(opMember.isPresent()) {
            return opMember.get();
        } else {
            throw new UsernameNotFoundException("Username not found");
        }
    }
}
