package lecture.splearn.application.member.provided;

import lecture.splearn.domain.member.Member;

/**
 * 회원을 조회한다.
 */
public interface MemberFinder {
    Member find(Long memberId);
}
