package wahaha.exception;


public class BusinessException extends Exception{

    private String exceptionDesc;

    public BusinessException(Exception e){
        super(e);
    }

    BusinessException(Exception e, String exceptionDesc){
        super(e);
        this.exceptionDesc = exceptionDesc;
    }
    BusinessException(){}
    BusinessException(String exceptionDesc){
        this.exceptionDesc = exceptionDesc;
    }

    public BusinessException(String message, String exceptionDesc) {
        super(message);
        this.exceptionDesc = exceptionDesc;
    }

    public BusinessException(String message, Throwable cause, String exceptionDesc) {
        super(message, cause);
        this.exceptionDesc = exceptionDesc;
    }

    public BusinessException(Throwable cause, String exceptionDesc) {
        super(cause);
        this.exceptionDesc = exceptionDesc;
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String exceptionDesc) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.exceptionDesc = exceptionDesc;
    }



    public String getExceptionDesc() {
        return exceptionDesc;
    }

    public void setExceptionDesc(String exceptionDesc) {
        this.exceptionDesc = exceptionDesc;
    }
}