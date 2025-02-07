package java16.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_gen")
    @SequenceGenerator(name = "id_gen",sequenceName = "UsPr_seq",allocationSize = 1)
    private Long id;
    @Column(unique = true)
    private String user_name;
    @Column(unique = true)
    private String email;
    private LocalDate registrationDate;

    @OneToOne(mappedBy = "userProfile", cascade = PERSIST,fetch = FetchType.EAGER)
    private UserDetail userDetail;

    public UserProfile(String user_name, String email, LocalDate registrationDate) {
        this.user_name = user_name;
        this.email = email;
        this.registrationDate = registrationDate;
    }
    public UserProfile(Long id) {
        this.id = id;
    }
}
