package be.evoliris.formation.webapp.model;

import be.evoliris.formation.webapp.model.enums.CadreFields;

import javax.persistence.Entity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Entity
public class Cadre extends Personnel{


    public void addField(CadreFields field, String value){
        switch (field){
            case NOM:
                this.nom = value;
                break;
            case PRENOM:
                this.prenom = value;
                break;
            case ADRESSE:
                this.adresse = adresse;
                break;
            case SALAIRE:
                this.salaire = Double.parseDouble(value);
                break;
//            case DATE_IN:
//                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//                try {
//                    this.dateEmploie = LocalDate.from(format.parse(value).toInstant());
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                break;
            default: break;
        }
    }
}
