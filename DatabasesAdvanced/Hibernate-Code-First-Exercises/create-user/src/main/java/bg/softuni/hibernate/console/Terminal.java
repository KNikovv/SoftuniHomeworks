package bg.softuni.hibernate.console;

import bg.softuni.hibernate.entities.User;
import bg.softuni.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
@Transactional
public class Terminal implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... strings) throws Exception {

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter picture width : ");
//        int width = scanner.nextInt();
//        User user = new User();
//        user.setUsername("Gosho");
//        user.setPassword("4a4klm#A");
//        user.setEmail("pesho@gmail.com");
//        user.setAge(11);
//        User user1 = new User();
//        user1.setUsername("Penko");
//        user1.setEmail("kiro@gmail.com");
//        user1.setPassword("4a4klm#A");
//        user1.setAge(12);

        User user2 = new User();
        user2.setUsername("blaaa");
        user2.setPassword("A4k#aab");
        user2.setEmail("pesho@abv.bg");
        Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        user2.setLastTimeLoggedIn(date);

        this.userService.create(user2);


        Date date1 = new GregorianCalendar(2014, Calendar.FEBRUARY, 6).getTime();

        this.userService.setDeletedTrueIfUnactive(date1);
        int deletedUnactiveUsers = this.userService.deleteMarkedUsers();
        System.out.printf("Deleted users count: %d \n",deletedUnactiveUsers);

//        int count = this.userService.deleteMarkedUsers();
//        System.out.println(count);
        //getProfilePicCount(width, user2);
//
//        int resultCount = getProfilePicCount(width);
//
//        System.out.printf(resultCount > 1 ?
//                String.format("%d users have profile pictures wider than %d pixels", resultCount, width) :
//                (resultCount == 0 ? String.format("No user have profile picture wider than %d pixels", width) :
//                        String.format("1 user have profile picture wider than %d pixels", width)));

//        List<User> users = this.userService.getUsersByEmailProvider("gmail.com");
//
//        for (User u : users) {
//            System.out.printf("%s %s\n", u.getUsername(), u.getEmail());
//        }

//        Country country = new Country();
//        country.setName("Bulgaria");
//        this.countryService.create(country);
//
//        Town town1 = new Town();
//        Town town2 = new Town();
//        town1.setName("Veliko Tarnovo");
//        town2.setName("Sofia");
//        town1.setCountry(country);
//        town2.setCountry(country);
//        this.townService.create(town1);
//        this.townService.create(town2);
//
//        user.setBornTown(town1);
//        user.setLivingTown(town2);
//        this.userService.create(user);
    }


    private int getProfilePicCount(int width) throws IOException {
        File file = new File("resources/pictures-14.jpg");
        FileInputStream fis = new FileInputStream(file);
        byte[] first = new byte[(int) file.length()];
        fis.read(first);

        return this.userService.getCountOfPicturesWithWidthAbove(width);
    }


}
