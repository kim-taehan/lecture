package lecture.splearn.domain;

public record
MemberRegisterRequest(
        String email,
        String nickname,
        String password
) {
}
