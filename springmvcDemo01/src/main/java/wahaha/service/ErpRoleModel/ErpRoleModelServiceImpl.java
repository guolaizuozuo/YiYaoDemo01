package wahaha.service.ErpRoleModel;

import org.springframework.stereotype.Service;
import wahaha.mapper.ErpRoleModelMapper;
import wahaha.model.ErpRoleModel;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ErpRoleModelServiceImpl implements ErpRoleModelService {
    @Resource
    private ErpRoleModelMapper dao;


    @Override
    public List<ErpRoleModel> getMessage(String roleId) {
        return dao.getMessage(roleId);
    }

    @Override
    public int insertSelective(ErpRoleModel record) {
        return dao.insertSelective(record);
    }
}
