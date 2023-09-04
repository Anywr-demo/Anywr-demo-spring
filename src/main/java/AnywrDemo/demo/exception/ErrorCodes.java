package AnywrDemo.demo.exception;

public enum ErrorCodes {

    ARTICE_NOT_FOUND(1000),
    ARTICLE_NOT_VALID(1004),
    COLLABORATEUR_NOT_FOUND(2000),

    COLLABORATOR_CHANGEPASSWORD_INVALID(2005),

    DEPARTMENT_NOT_FOUND(3000),
    ABSENCE_NOT_FOUND(4000),

    ABSENCE_AUDIT_NOT_FOUND(5000),

    LIGNE_DEMANDE_ARTICLE_NOT_FOUND(6000),

    MVT_DESTOCK_NOT_FOUND(7000),

    PAYEMENT_NOT_FOUND(8000),

    REFUSAL_REASON_NOT_FOUND(9000),

    DEMANDE_ARTICLE_NOT_FOUND(10000),
    ;




    private int code;

    ErrorCodes(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}
