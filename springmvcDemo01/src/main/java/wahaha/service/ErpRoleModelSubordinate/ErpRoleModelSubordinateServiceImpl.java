package wahaha.service.ErpRoleModelSubordinate;

import org.springframework.stereotype.Service;
import wahaha.mapper.ErpRoleModelSubordinateMapper;
import wahaha.model.ErpRoleModelSubordinate;

import javax.annotation.Resource;

@Service
public class ErpRoleModelSubordinateServiceImpl implements ErpRoleModelSubordinateService {
    @Resource
    private ErpRoleModelSubordinateMapper dao;

    @Override
    public int insertSelective(ErpRoleModelSubordinate record) {
        return dao.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(String subId) {
        return dao.deleteByPrimaryKey(subId);
    }

}
