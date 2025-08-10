package lecture.splearn.application;

import jakarta.transaction.Transactional;
import lecture.splearn.application.provided.MemberRegister;
import lecture.splearn.application.required.EmailSender;
import lecture.splearn.application.required.MemberRepository;
import lecture.splearn.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Transactional
@RequiredArgsConstructor
@Validated
public class MemberModifyService implements MemberRegister {
    private final MemberQueryService memberQueryService;
    private final MemberRepository memberRepository;
    private final EmailSender emailSender;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Member register(MemberRegisterRequest registerRequest) {
        checkDuplicateEmail(registerRequest);

        Member member = Member.register(registerRequest, passwordEncoder);

        memberRepository.save(member);

        sendWelcomeEmail(member);

        return member;
    }

    @Override
    public Member activate(Long memberId) {
        Member member = memberQueryService.find(memberId);

        member.activate();

        return memberRepository.save(member);
    }

    private void checkDuplicateEmail(MemberRegisterRequest registerRequest) {
        if(memberRepository.findByEmail(new Email(registerRequest.email())).isPresent()) {
            throw new DuplicateEmailException("이미 사용중인 이메일입니다." + registerRequest.email());
        }
    }

    private void sendWelcomeEmail(Member member) {
        emailSender.send(member.getEmail(), "등록을 완료해주세요", "아래 링크를 클릭해서 등록을 완료해주세요");
    }
}
