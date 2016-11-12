package app.service;

import app.dao.VisitationDao;
import app.entities.Visitation;
import app.service.interfaces.VisitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitationServiceImpl implements VisitationService {

    private final VisitationDao visitationDao;

    @Autowired
    public VisitationServiceImpl(VisitationDao visitationDao) {
        this.visitationDao = visitationDao;
    }

    @Override
    public void create(Visitation visitation) {
        this.visitationDao.saveAndFlush(visitation);
    }
}
