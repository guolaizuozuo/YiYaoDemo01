package wahaha.po;

import java.util.Date;

/**
 * 用户操作记录DO
 *
 * @author Ken
 * @since 2017/4/9.
 */
public class UserOperationRecord {

    /**
     * 记录ID
     */
    private Integer id;

    /**
     * 执行操作的用户ID
     */
    private String userID;

    /**
     * 执行操作的用户名
     */
    private String userName;

    /**
     * 操作的名称
     */
    private String operationName;

    /**
     * 执行操作的时间
     */
    private Date operationTime;

    /**
     * 执行操作结果
     */
    private String operationResult;

    private String operationArgs;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public void setOperationResult(String operationResult) {
        this.operationResult = operationResult;
    }

    public Integer getId() {
        return id;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getOperationName() {
        return operationName;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public String getOperationResult() {
        return operationResult;
    }

    public String getOperationArgs() {
        return operationArgs;
    }

    public void setOperationArgs(String operationArgs) {
        this.operationArgs = operationArgs;
    }

    @Override
    public String toString() {
        return "UserOperationRecord{" +
                "id=" + id +
                ", userID=" + userID +
                ", userName='" + userName + '\'' +
                ", operationName='" + operationName + '\'' +
                ", operationTime=" + operationTime +
                ", operationResult='" + operationResult + '\'' +
                ", operationResult='" + operationResult + '\'' +
                '}';
    }
}
