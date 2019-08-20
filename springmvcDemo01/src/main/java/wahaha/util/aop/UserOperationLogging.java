package wahaha.util.aop;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import wahaha.exception.SystemLogServiceException;
import wahaha.model.ErpStaff;
import wahaha.service.SystemLog.SystemLogService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

public class UserOperationLogging {
   @Resource
    private SystemLogService systemLogService;

    /**
     * 记录用户操作
     *
     * @param joinPoint 切入点信息
     */
    public void loggingUserOperation(JoinPoint joinPoint, Object returnValue, UserOperation userOperation) throws JsonProcessingException {

        if (userOperation != null) {
            // 获取 annotation 的值
            String userOperationValue = userOperation.value();

            // 获取调用的方法名
            String methodName = joinPoint.getSignature().getName();

            // 获取除 import* export* 外的方法的返回值
            String invokedResult = "-";
            if (!methodName.matches("^import\\w*") && !methodName.matches("^export\\w*")) {
                if (returnValue instanceof Boolean) {
                    boolean result = (boolean) returnValue;
                    invokedResult = result ? "成功" : "失败";
                }
            }

            // 获取用户信息
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            ErpStaff userInfo= (ErpStaff) request.getSession().getAttribute("staff");
            String userID = userInfo.getStaId();
            String userName = userInfo.getStaName();

            ObjectMapper mapper = new ObjectMapper();
            Object[] args= joinPoint.getArgs();
            String json = mapper.writeValueAsString(args);

           /* try {
                反序列demo
                Object[] oooo = mapper.readValue(json, Object[].class);
                System.out.println(oooo);
            } catch (IOException e) {
                e.printStackTrace();
            }*/


            // 插入记录UserOperationRecordMapper
            try {
                systemLogService.insertUserOperationRecord(userID, userName, userOperationValue, invokedResult,json);
            } catch (SystemLogServiceException e) {
                // do log
            }
        }
    }

}
