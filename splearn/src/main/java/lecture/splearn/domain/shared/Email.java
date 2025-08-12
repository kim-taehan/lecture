package lecture.splearn.domain.shared;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.regex.Pattern;

@Embeddable
public record Email(
        @Column(length = 150, nullable = false, name = "email_address")
        String address
) {
    private final static Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    public Email {

        if(!EMAIL_PATTERN.matcher(address).matches()) {
            throw new IllegalArgumentException("email format not allow " + address);
        }
    }
}
