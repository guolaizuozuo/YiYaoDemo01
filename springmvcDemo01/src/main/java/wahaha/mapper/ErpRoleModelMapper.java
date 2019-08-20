package wahaha.mapper;

import wahaha.model.ErpRoleModel;

import java.util.List;

public interface ErpRoleModelMapper {
    List<ErpRoleModel> getMessage(String roleId);
    int insertSelective(ErpRoleModel record);
}
