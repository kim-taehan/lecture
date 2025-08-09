package lecture.splearn.domain;

public record
MemberCreateRequest(
        String email,
        String nickname,
        String password
) {
}
