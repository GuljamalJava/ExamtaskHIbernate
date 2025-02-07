package java16;

import java16.config.HibernateConfig;
import java16.entities.UserDetail;
import java16.entities.UserProfile;
import java16.service.UserProfileService;
import java16.service.UserdetailService;
import java16.service.impl.UserProfileServiceImpl;
import java16.service.impl.UserdetailServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

import static java.time.LocalDate.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        UserdetailService service = new UserdetailServiceImpl();
        UserProfileService profileService = new UserProfileServiceImpl();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write command:");
        int command = scanner.nextInt();
//        System.out.println("DataBase  connection:");
//        HibernateConfig.getEntityManagerFactory();
       switch (command){
           case 1 -> {
               System.out.println("Create a new UserProfile:");

               profileService.createUserProfile(new UserProfile("Aibek", "Aibek@gmail.com", (of(2024, 3, 4))));


           }case 2-> {
               System.out.println("Create a new  UserDetail with Profile:");

               service.createUserDetail(3L, new UserDetail("Aigul Akylbekova", of(2010, 1, 10), "Fuchik 100", new UserProfile("Aygul", "Aigul@gmail.com", of(2024, 3, 3))));

               service.createUserDetail(2L, new UserDetail("Kanchoro Maraimov", of(2003, 1, 10), "Kelechek 10",

                       new UserProfile("Kanchoro", "kanchoro@gmail.com", of(2024, 3, 3))));

               service.createUserDetail(1L, new UserDetail("Gulkaiyr Janybekova", of(1993, 12, 16), "Rabochii Gorordok 100", new UserProfile("Gulkayir", "Gulkayir@gmail.com", of(2023, 5, 6))));
           }case 3 ->{
               System.out.println("Find UserDetails By ID:");
               service.getUserDetailsByID(1L);
           }case 4->{
               System.out.println("Get UserProfile By Id:");
               profileService.getUserProfileById(2L);
           }case 5-> {
               System.out.println("Delete UserProfile By Id:");
               profileService.deleteUserProfileById(1L);
           }case 6->{
               System.out.println("Update UserProfile By Id:");
               profileService.updateUserProfileEmail(1L,"dev@gmail.com");
           }case 7->{
               System.out.println("Update UserDetail By Address:");
               service.updateUserDetailsAddress(4L,"Grajdanskaya 119");
           }case 8-> {
               System.out.println("Users By Date Of Birth:");
               service.sortUsersByDateOfBirth();
           }case 9 -> {
               System.out.println("Get UserDetail by Address:");
               service.getUserDetailByAddress("Rabochii Gorordok 100");
           }case 10 -> {
               System.out.println("Find User By Email:");
               profileService.findUserByEmail("Gulkayir@gmail.com");
           }case 11->{
               System.out.println("Get Users RegisteredAfterDate:");
               LocalDate reg_date = LocalDate.of(2023,5,6);
               String usersRegDate = profileService.getUsersRegisteredAfterDate(reg_date);
               System.out.println("usersRegDate = " + usersRegDate);
           }case 12->{
               System.out.println("Delete UserDetail By Id:");
               service.deleteUserDetailsByID(2L);
           }

       }













    }
}
