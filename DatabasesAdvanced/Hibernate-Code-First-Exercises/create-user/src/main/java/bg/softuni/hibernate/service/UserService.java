package bg.softuni.hibernate.service;

import bg.softuni.hibernate.entities.User;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface UserService {

    void create(User user);

    List<User> getUsersByEmailProvider(String emailProvider);

    int getCountOfPicturesWithWidthAbove(int width) throws IOException;

    void setDeletedTrueIfUnactive(Date date);

    int deleteMarkedUsers();
}
