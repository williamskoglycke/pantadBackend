package se.academy.pantad.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class UserProfile {

    private Long id;
    private String name;

}
