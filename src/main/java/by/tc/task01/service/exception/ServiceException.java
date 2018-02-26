package by.tc.task01.service.exception;

public class ServiceException extends Exception{
    private int errorCode;

    public void setErrorCode(int errorCode){
        this.errorCode=errorCode;
    }
    public int gerErrorCode(){
        return errorCode;
    }
}
