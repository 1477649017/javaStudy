/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-06-25
 * Time: 21:35
 */
//自定义异常类
public class AddPosLegalException extends RuntimeException{
    public AddPosLegalException(){};
    public AddPosLegalException(String msg){
        super(msg);
    }
}
