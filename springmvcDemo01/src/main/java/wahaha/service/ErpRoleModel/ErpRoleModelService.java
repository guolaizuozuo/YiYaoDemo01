package wahaha.service.ErpRoleModel;

import wahaha.model.ErpRoleModel;

import java.util.List;

public interface ErpRoleModelService {
    List<ErpRoleModel> getMessage(String roleId);
    int insertSelective(ErpRoleModel record);
}
