package se.academy.pantad.domain;

import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {

        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotBlank
    @Size(max = 40)
    private String name;

    @NonNull
    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NonNull
    @NotBlank
    @Size(max = 100)
    private String password;

    @NonNull
    @NotBlank
    @Size(max = 40)
    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @NonNull
    private boolean isSchoolclass;

    public void addRoleToUser(Role role){
        roles.add(role);
    }



}
