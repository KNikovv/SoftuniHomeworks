package bg.softuni.hibernate.service;

import bg.softuni.hibernate.dao.UserDao;
import bg.softuni.hibernate.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDAO;

    @Autowired
    public UserServiceImpl(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void create(User user) {
        this.userDAO.saveAndFlush(user);
    }

    @Override
    public List<User> getUsersByEmailProvider(String emailProvider) {
        List<User> users = this.userDAO.findAll();
        List<User> results = new LinkedList<>();
        for (User user : users) {
            String email = user.getEmail();
            String ep = email.substring(email.indexOf("@") + 1);
            if (ep.equals(emailProvider)) {
                results.add(user);
            }
        }

        return results;
    }

    @Override
    public void setDeletedTrueIfUnactive(Date date) {
        List<User> unactive = this.userDAO.findByLastTimeLoggedInAfter(date);

        for (User user : unactive) {
            user.setDeleted(true);
        }
    }

    @Override
    public int deleteMarkedUsers() {
        return this.userDAO.removeByDeletedTrue();
    }

    public int getCountOfPicturesWithWidthAbove(int width) throws IOException {
        List<User> users = this.userDAO.findAll();

        int count = 0;
        for (User user : users) {
            int picWidth = getPictureWidth(user);
            count = picWidth > width ? count + 1 : count;
        }

        return count;
    }


    private int getPictureWidth(User user) throws IOException {
        byte[] currentPic = user.getProfilePicture();
        InputStream in = new ByteArrayInputStream(currentPic);
        BufferedImage buf = ImageIO.read(in);
        return buf.getWidth();
    }
}
