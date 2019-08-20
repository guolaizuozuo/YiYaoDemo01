package wahaha.service.SystemLog;

import wahaha.exception.SystemLogServiceException;

public interface SystemLogService {
    String ACCESS_TYPE_LOGIN = "login";
    String ACCESS_TYPE_LOGOUT = "logout";

    /**
     * 插入用户操作记录
     *
     * @param userID          执行操作的用户ID
     * @param userName        执行操作的用户名
     * @param operationName   操作的名称
     * @param operationResult 操作的记过
     */
    void insertUserOperationRecord(String userID, String userName, String operationName, String operationResult,String operationArgs)  throws SystemLogServiceException;

}