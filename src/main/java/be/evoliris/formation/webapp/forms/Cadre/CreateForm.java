package be.evoliris.formation.webapp.forms.Cadre;

import be.evoliris.formation.webapp.model.Cadre;
import be.evoliris.formation.webapp.model.enums.CadreFields;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class CreateForm {
    String result;
    Map<String,String> erreurs = new HashMap<>();
    Logger logger = Logger.getLogger(CreateForm.class.getName());
    public Cadre create(HttpServletRequest request)
    {

        Cadre cadre = new Cadre();
        CadreFields[] cadreFields = CadreFields.values();
        Map<CadreFields, String> values = new HashMap<>();
        //on récupère les valeurs
        for(CadreFields field: cadreFields){
            String value = getValueField(request,field);
            logger.info(field.toString()+":"+value);
            values.put(field,value);
        }

        //on vérifies si les valeurs sont corrextes
        for(Map.Entry<CadreFields,String> entry: values.entrySet())
        {
            try{
//                validation(entry.getKey(),entry.getValue());
                cadre.addField(entry.getKey(), entry.getValue());
            }catch (Exception e)
            {
                addErreur(entry.getKey(),e.getMessage());
            }
        }
        if(erreurs.size() != 0){
            result = "Création échouée !";
        }else{
            result = "Création réussie !";
        }
        return  cadre;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }



    private void addErreur(CadreFields key, String message) {

        erreurs.put(key.getDbName(),message);
    }

    private void validation(CadreFields key, String value) throws Exception {
        if(value==null && !key.isOptional() )
            throw new Exception(key.getFormatName()+" est obligatoire");
        else if(value!=null)
            if(key.getRgx()!=null && !value.matches(key.getRgx()))
                throw new Exception(key.getErrorMsg());
      }

    private String getValueField(HttpServletRequest request, CadreFields field){
        String values = request.getParameter(field.getDbName());
        logger.info("Test values for:"+field.getDbName());

        return request.getParameter(field.getDbName());
    }
}
