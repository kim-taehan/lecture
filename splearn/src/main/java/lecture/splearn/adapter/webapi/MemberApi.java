package lecture.splearn.adapter.webapi;

import jakarta.validation.Valid;
import lecture.splearn.adapter.webapi.dto.MemberRegisterResponse;
import lecture.splearn.application.member.provided.MemberRegister;
import lecture.splearn.domain.member.Member;
import lecture.splearn.domain.member.MemberRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberApi {

    private final MemberRegister memberRegister;

    @PostMapping("/api/members")
    public MemberRegisterResponse register(@RequestBody @Valid MemberRegisterRequest request) {
        Member member = memberRegister.register(request);

        return MemberRegisterResponse.of(member);
    }


}
