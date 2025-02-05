package java16.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    private String full_name;
    private LocalDate dateOfBirth;

    @OneToOne
    private UserDetail userDetail;

    public UserProfile(String full_name, LocalDate dateOfBirth, UserDetail userDetail) {
        this.full_name = full_name;
        this.dateOfBirth = dateOfBirth;
        this.userDetail = userDetail;
    }
}
