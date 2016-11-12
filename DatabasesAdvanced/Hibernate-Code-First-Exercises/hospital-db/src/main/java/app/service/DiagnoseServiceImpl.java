package app.service;

import app.dao.DiagnoseDao;
import app.entities.Diagnose;
import app.service.interfaces.DiagnoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnoseServiceImpl implements DiagnoseService {

    private final DiagnoseDao diagnoseDao;

    @Autowired
    public DiagnoseServiceImpl(DiagnoseDao diagnoseDao) {
        this.diagnoseDao = diagnoseDao;
    }

    @Override
    public void create(Diagnose diagnose) {
        this.diagnoseDao.saveAndFlush(diagnose);
    }
}
