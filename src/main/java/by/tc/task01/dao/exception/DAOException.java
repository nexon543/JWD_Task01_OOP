package by.tc.task01.dao.exception;

public class DAOException extends Exception{

    private int errorCode;

    public static int SOURCE_ERROR=0;
    public static int RECORD_ERROR=1;


    public DAOException(int errorCode){
        this.errorCode=errorCode;
    }


    public String toString(){
        return "DAOException with error code:"+errorCode;
    }
}
