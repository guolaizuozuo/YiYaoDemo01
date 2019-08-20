package wahaha.mapper;

import wahaha.model.ErpRole;

import java.util.List;

public interface ErpRoleMapper {
    List<ErpRole> findAll();
    List<ErpRole> findAllRole(ErpRole record);
    int findRowCount(ErpRole record);
    int insertSelective(ErpRole record);

    int updateByPrimaryKeySelective(ErpRole record);

    List<ErpRole>getRoleValue(String roleId);
    int deleteModel(String roleId);

    int deleteRole(String roleId);
}
