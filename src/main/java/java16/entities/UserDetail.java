package java16.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "detail_gen")
    @SequenceGenerator(name="detail_gen",sequenceName = "detail_seq", allocationSize = 1)
    private Long id;

    private String userName;
    private String address;
    private LocalDate registrationDate;


    @OneToOne
    private UserProfile profile;

    public UserDetail(String userName, String address, LocalDate registrationDate, UserProfile profile) {
        this.userName = userName;
        this.address = address;
        this.registrationDate = registrationDate;
        this.profile = profile;
    }
}
