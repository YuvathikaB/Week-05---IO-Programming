package Intermediate;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}
class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        this.username = username;
        validateMaxLength();
    }
    private void validateMaxLength() {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                field.setAccessible(true);
                MaxLength annotation = field.getAnnotation(MaxLength.class);
                try {
                    Object value = field.get(this);
                    if (value instanceof String && ((String) value).length() > annotation.value()) {
                        throw new IllegalArgumentException(
                                String.format("Field '%s' exceeds max length of %d",
                                        field.getName(), annotation.value()));
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed to access field", e);
                }
            }
        }
    }
    public String getUsername() {
        return username;
    }
}
public class MaxiLength {
        public static void main(String[] args) {
            try {
                User user1 = new User("JohnDoe"); // Valid username
                System.out.println("User created: " + user1.getUsername());

                User user2 = new User("TooLongUsernameHere"); // Invalid: exceeds max length
                System.out.println("User created: " + user2.getUsername());

            } catch (IllegalArgumentException e) {
                System.out.println("Validation failed: " + e.getMessage());
            }
        }
}

