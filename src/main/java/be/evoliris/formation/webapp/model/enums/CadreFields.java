package be.evoliris.formation.webapp.model.enums;

public enum CadreFields {
//    ID("pers_id","id", "text", false),
    NOM("nom","nom", "text", false, "(\\s*\\w{3,10})*",
        "le nom doit avoit au moins 3 lettres"),
    PRENOM("prenom","prénom", "text", false,"(\\s*\\w{3,10})*",
            "le prénom doit avoit au moins 3 lettres"),
    SALAIRE("salaire","salaire ", "text", false,"\\d*[.]?\\d*",
            "mauvais format du salaire"),
    ADRESSE("adresse","adresse", "text", false,"\\w*",
            "entrez une adresse valide")
    ,
    DATE_IN("dateEmploie","Date dernier emploi", "date", true)
    ;


    private CadreFields(String dbName, String formatName, String inputType, boolean isOptional,String regex) {
     this(dbName,formatName,inputType,isOptional);
     this.rgx = regex;
    }

    private CadreFields(String dbName, String formatName, String inputType, boolean isOptional,String regex,String error) {
        this(dbName,formatName,inputType,isOptional,regex);
        this.errorMsg = error;
    }

    private CadreFields(String dbName, String formatName, String inputType, boolean isOptional) {
        this.dbName = dbName;
        this.formatName = formatName;
        this.inputType = inputType;
        this.isOptional = isOptional;
    }
    public String getDbName() {
        return dbName;
    }

    public String getFormatName() {
        return formatName;
    }

    public String getInputType() {
        return inputType;
    }

    public boolean getIsOptional() {
        return isOptional;
    }

    public boolean isOptional() {
        return isOptional;
    }

    public String getRgx() {
        return rgx;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    private String dbName;
    private String formatName;
    private String inputType;
    private boolean isOptional;
    private String rgx;
    private String errorMsg;
}
