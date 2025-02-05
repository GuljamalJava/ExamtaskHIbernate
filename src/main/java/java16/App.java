package java16;

import java16.config.HibernateConfig;
import java16.entities.UserDetail;
import java16.entities.UserProfile;
import java16.service.UserProfileService;
import java16.service.UserdetailService;
import java16.service.impl.UserProfileServiceImpl;
import java16.service.impl.UserdetailServiceImpl;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
//        HibernateConfig.getEntityManagerFactory();
        UserdetailService service = new UserdetailServiceImpl();
        UserProfileService profileService = new UserProfileServiceImpl();
//         todo Create UserDetail
//         service.createUserDetail(1L,new UserDetail("Maria_123","sdlkv", LocalDate.of(2024,06,15),new UserProfile()));
//    todo Create UserProfile
        profileService.createUserProfile(new UserProfile("aibek Duisho uulu",LocalDate.of(2024,03,04),new UserDetail()));
    }
}
