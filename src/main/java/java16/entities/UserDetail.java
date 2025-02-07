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

@ToString(exclude = "userProfile")
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detail_gen")
    @SequenceGenerator(name = "detail_gen", sequenceName = "detail_seq", allocationSize = 1)
    private Long id;

    private String full_name;
    private LocalDate dateOfBirth;
    private String address;

//    @ToString(exclude = "userProfile")
    @OneToOne( cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private UserProfile userProfile;

    public UserDetail(String full_name, LocalDate dateOfBirth, String address, UserProfile userProfile) {
        this.full_name = full_name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.userProfile = userProfile;
    }

    public  UserDetail(Long id){
        this.id = id;
    }


//    @Override
//    public String toString() {
//        return "UserDetail{" +
//                "id=" + id +
//                ", full_name='" + full_name + '\'' +
//                ", dateOfBirth=" + dateOfBirth +
//                ", address='" + address + '\'' +
//                ", userProfile=" + userProfile +
//                '}';
//    }
}

