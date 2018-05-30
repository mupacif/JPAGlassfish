package be.evoliris.formation.webapp.servlet;

import be.evoliris.formation.webapp.Repositories.PersonnelRepository;
import be.evoliris.formation.webapp.forms.Cadre.CreateForm;
import be.evoliris.formation.webapp.model.Cadre;
import be.evoliris.formation.webapp.model.enums.CadreFields;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "signup", urlPatterns = {"/signup"})
public class SignUpServlet extends HttpServlet {
    Logger logger = Logger.getLogger(SignUpServlet.class.getName());

    @EJB
    PersonnelRepository userRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<Cadre> cadres = userRepository.findCadres();

logger.warning("Action is comming !!");
        logger.info(cadres.size()+"");
        req.setAttribute("form",CadreFields.values());
        req.getRequestDispatcher("signup.ftl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateForm createForm = new CreateForm();
        Cadre cadre = createForm.create(req);

        if(createForm.getErreurs().size() > 0)
        {
            logger.warning("ERRORS");
            createForm.getErreurs().forEach((s, s2) -> logger.info(s+":"+s));
            req.setAttribute("form",CadreFields.values());
            req.setAttribute("errors",createForm.getErreurs());
            req.getRequestDispatcher("signup.ftl").forward(req,resp);
        }
        else {

            userRepository.insertUser(cadre);
            req.getRequestDispatcher("signup.ftl").forward(req, resp);
        }

    }
}
