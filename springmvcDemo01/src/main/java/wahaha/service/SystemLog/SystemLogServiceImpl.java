package wahaha.service.SystemLog;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wahaha.exception.SystemLogServiceException;
import wahaha.mapper.UserOperationRecordMapper;
import wahaha.po.UserOperationRecord;

import java.util.Date;

@Service
public class SystemLogServiceImpl implements  SystemLogService {
    @Autowired
    private UserOperationRecordMapper userOperationRecordMapper;

    @Override
    public void insertUserOperationRecord(String userID, String userName, String operationName, String operationResult,String operationArgs) throws SystemLogServiceException {
        // 创建 UserOperationRecordDO 对象
        UserOperationRecord userOperationRecordDO = new UserOperationRecord();
        userOperationRecordDO.setUserID(userID);
        userOperationRecordDO.setUserName(userName);
        userOperationRecordDO.setOperationName(operationName);
        userOperationRecordDO.setOperationResult(operationResult);
        userOperationRecordDO.setOperationArgs(operationArgs);
        userOperationRecordDO.setOperationTime(new Date());

        // 将数据持久化到数据库
        try {
            userOperationRecordMapper.insertUserOperationRecord(userOperationRecordDO);
        } catch (PersistenceException e) {
            throw new SystemLogServiceException(e, "Fail to persist usrOperationRecordDo Object");
        }
    }
}
