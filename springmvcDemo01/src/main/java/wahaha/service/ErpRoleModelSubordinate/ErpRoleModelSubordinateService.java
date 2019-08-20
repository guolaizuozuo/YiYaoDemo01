package wahaha.service.ErpRoleModelSubordinate;

import wahaha.model.ErpRoleModelSubordinate;

public interface ErpRoleModelSubordinateService {
    int insertSelective(ErpRoleModelSubordinate record);

    int deleteByPrimaryKey(String subId);
}
