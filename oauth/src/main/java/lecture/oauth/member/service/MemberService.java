package lecture.oauth.member.service;

import lecture.oauth.member.domain.Member;
import lecture.oauth.member.domain.SocialType;
import lecture.oauth.member.dto.MemberCreateDto;
import lecture.oauth.member.dto.MemberLoginDto;
import lecture.oauth.member.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Member create(MemberCreateDto memberCreateDto) {
        Member member = Member.builder()
                .email(memberCreateDto.getEmail())
                .password(passwordEncoder.encode(memberCreateDto.getPassword()))
                .build();
        memberRepository.save(member);
        return member;
    }

    public Member login(MemberLoginDto memberLoginDto) {

        Member member = memberRepository.findByEmail(memberLoginDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("eamil 이 존재하지 않습니다."));

        if (!passwordEncoder.matches(memberLoginDto.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("password not matched");
        }
        return member;
    }

    public Member getMemberBySocialId(String socialId) {
        return memberRepository.findBySocialId(socialId)
                .orElse(null);
    }

    @Transactional
    public Member createOauth(String socialId, String email, SocialType socialType) {
        Member member = Member.builder()
                .email(email)
                .socialId(socialId)
                .socialType(socialType)
                .build();
        memberRepository.save(member);
        return member;
    }
}
