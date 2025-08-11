package lecture.splearn.application.member.provided;

import jakarta.validation.Valid;
import lecture.splearn.domain.member.Member;
import lecture.splearn.domain.member.MemberInfoUpdateRequest;
import lecture.splearn.domain.member.MemberRegisterRequest;

/**
 * 회원은 등록과 관련된 기능을 제공한다.
 */
public interface MemberRegister {

    Member register(@Valid MemberRegisterRequest registerRequest);

    Member activate(Long memberId);

    Member deactivate(Long memberId);

    Member updateInfo(Long memberId, @Valid MemberInfoUpdateRequest updateRequest);
}
