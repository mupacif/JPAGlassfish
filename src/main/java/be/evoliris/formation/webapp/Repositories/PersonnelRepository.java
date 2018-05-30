package be.evoliris.formation.webapp.Repositories;

import be.evoliris.formation.webapp.model.Cadre;
import be.evoliris.formation.webapp.model.Personnel;


import javax.ejb.Remote;
import java.util.List;

@Remote
public interface PersonnelRepository {
    public List<Personnel> findUsers();
    public void insertUser(Personnel user);
    public List<Cadre> findCadres();
}
