package lecture.splearn.domain.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.regex.Pattern;

@Embeddable
public record Profile(@Column(length = 20, name = "profile_address") String address) {
    private final static Pattern PROFILE_PATTERN = Pattern.compile("[a-z0-9]+");

    public Profile {

        if(address == null || (!address.isEmpty() && !PROFILE_PATTERN.matcher(address).matches())) {
            throw new IllegalArgumentException("profile format not allow " + address);
        }

        if (address.length() > 15) {
            throw new IllegalArgumentException("프로필 주소는 최대 15자리를 넘을 수 없습니다.");
        }
    }

    public String url() {
        return "@" + address;
    }
}