package wahaha.service.ErpRole;

import wahaha.model.ErpRole;

import java.util.List;

public interface ErpRoleService {
    List<ErpRole>findAll();
    List<ErpRole> findAllRole(ErpRole record);
    int findRowCount(ErpRole record);

    int insertSelective(ErpRole record);

    int updateByPrimaryKeySelective(ErpRole record);
    List<ErpRole>getRoleValue(String roleId);
    int deleteModel(String roleId);

    //修改角色
   void  editRoleModelSubmit(String roleId,String[] roleModels,String[] roleModelSubs);


   int deleteRole(String roleId);
}
