package lecture.splearn.application.provided;

import lecture.splearn.domain.Member;

/**
 * 회원을 조회한다.
 */
public interface MemberFinder {
    Member find(Long memberId);
}
