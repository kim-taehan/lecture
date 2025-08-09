package lecture.splearn.domain;

import jakarta.persistence.Embeddable;

import java.util.regex.Pattern;

@Embeddable
public record Email(String address) {
    private final static Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    public Email {

        if(!EMAIL_PATTERN.matcher(address).matches()) {
            throw new IllegalArgumentException("email format not allow " + address);
        }
    }
}
