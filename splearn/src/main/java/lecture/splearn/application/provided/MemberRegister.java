package lecture.splearn.application.provided;

import jakarta.validation.Valid;
import lecture.splearn.domain.Member;
import lecture.splearn.domain.MemberRegisterRequest;

/**
 * 회원은 등록과 관련된 기능을 제공한다.
 */
public interface MemberRegister {

    Member register(@Valid MemberRegisterRequest registerRequest);

    Member activate(Long memberId);
}
