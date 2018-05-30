package be.evoliris.formation.webapp.Repositories;

import be.evoliris.formation.webapp.forms.Cadre.CreateForm;
import be.evoliris.formation.webapp.model.Cadre;
import be.evoliris.formation.webapp.model.Personnel;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class PersonnelRepositoryImp implements PersonnelRepository {

    Logger logger = Logger.getLogger(PersonnelRepositoryImp.class.getName());
    @PersistenceContext
    private EntityManager em;


    public void insertUser(Personnel user){
        logger.info("insert cadre");
        em.persist(user);
        em.flush();
    }

    @Override
    public List<Personnel> findUsers() {
        return em.createQuery("SELECT p FROM Personnel p", Personnel.class).getResultList();
    }

    @Override
    public List<Cadre> findCadres() {
        return em.createQuery("SELECT p FROM Cadre p", Cadre.class).getResultList();
    }


}


