package wahaha.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import wahaha.util.SsmMessage;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger("ExceptionLogging");

    /**
     * 捕获并记录Controller层抛出的非BusinessException异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public SsmMessage handleException(Exception e){
        SsmMessage msg=new SsmMessage();
        if ((e instanceof Exception)){
            //这一行是必须的，因为若小于error记录级别，logger.isErrorEnabled() 返回true;
            if (logger.isErrorEnabled()){
                StringBuilder builder = new StringBuilder();
                builder.append("cause:").append(e.getMessage());
                builder.append("\n\tstackTrack:\n");
                for (StackTraceElement stack : e.getStackTrace()) {
                    builder.append("\t\t");
                    builder.append(stack.toString());
                    builder.append("\n");
                }
                logger.error(builder.toString());
                msg.setMes("系统错误");
                msg.setState(500);
            }
        }
        return  msg;
    }
}
