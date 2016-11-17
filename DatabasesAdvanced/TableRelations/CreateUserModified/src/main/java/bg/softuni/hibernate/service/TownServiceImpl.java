package bg.softuni.hibernate.service;

import bg.softuni.hibernate.dao.TownDao;
import bg.softuni.hibernate.entities.Town;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TownServiceImpl implements TownService {

    private final TownDao townDao;

    @Autowired
    public TownServiceImpl(TownDao townDao) {
        this.townDao = townDao;
    }

    @Override
    public void create(Town town) {
        this.townDao.saveAndFlush(town);
    }
}
