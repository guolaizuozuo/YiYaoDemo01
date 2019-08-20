package wahaha.service.ErpRole;

import org.springframework.stereotype.Service;
import wahaha.mapper.ErpRoleMapper;
import wahaha.mapper.ErpRoleModelMapper;
import wahaha.mapper.ErpRoleModelSubordinateMapper;
import wahaha.model.ErpRole;
import wahaha.model.ErpRoleModel;
import wahaha.model.ErpRoleModelSubordinate;
import wahaha.util.aop.UserOperation;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ErpRoleServiceImpl implements ErpRoleService {
    @Resource
    private ErpRoleMapper dao;
    @Resource
    private ErpRoleModelSubordinateMapper roleModelSubDao;
    @Resource
    private ErpRoleModelMapper roleModeDao;


    @Override
    public int insertSelective(ErpRole record) {
        return dao.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(ErpRole record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<ErpRole> getRoleValue(String roleId) {
        return dao.getRoleValue(roleId);
    }

    @Override
    public int deleteModel(String roleId) {
        return dao.deleteModel(roleId);
    }


    @UserOperation(value = "修改用户信息")
    @Override
    public void editRoleModelSubmit(String roleId, String[] roleModels, String[] roleModelSubs) {
        //先删除原有的子模块数据
        roleModelSubDao.deleteByPrimaryKey(roleId);
        //先删除原有的模块数据
        dao.deleteModel(roleId);

        for (int i = 0; i < roleModels.length; i++) {
            ErpRoleModel model = new ErpRoleModel();
            model.setRoleModelId(UUID.randomUUID().toString());
            model.setRoleId(roleId);
            model.setModelId(roleModels[i]);
            roleModeDao.insertSelective(model);
        }

      /*  int a=0;
        int b=10/a;*/
        List<ErpRoleModelSubordinate> subList = new ArrayList<ErpRoleModelSubordinate>();

        for (int i = 0; i < roleModelSubs.length; i++) {
            ErpRoleModelSubordinate sub = new ErpRoleModelSubordinate();
            sub.setRoleId(roleId);
            sub.setModelId(roleModelSubs[i]);
            sub.setSubId(UUID.randomUUID().toString());
//            roleModelSubdao.insertSelective(sub); 老的删除，改成批处理添加
            subList.add(sub);
        }
        roleModelSubDao.insertBatchSelective(subList);
        System.out.println(subList.toArray());
    }

    @Override
    public int deleteRole(String roleId) {
        return dao.deleteRole(roleId);
    }

    @Override
    public List<ErpRole> findAll() {
        return dao.findAll();
    }

    @Override
    public List<ErpRole> findAllRole(ErpRole record) {
        return dao.findAllRole(record);
    }

    @Override
    public int findRowCount(ErpRole record) {
        return dao.findRowCount(record);
    }
}
