package bg.softuni.hibernate.service;

import bg.softuni.hibernate.dao.CountryDao;
import bg.softuni.hibernate.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryDao countryDao;

    @Autowired
    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    public void create(Country country) {
        this.countryDao.saveAndFlush(country);
    }
}
