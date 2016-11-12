package app.service;

import app.dao.DoctorDao;
import app.entities.Doctor;
import app.service.interfaces.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorDao doctorDao;

    @Autowired
    public DoctorServiceImpl(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    @Override
    public void create(Doctor doctor) {
        this.doctorDao.saveAndFlush(doctor);
    }
}
