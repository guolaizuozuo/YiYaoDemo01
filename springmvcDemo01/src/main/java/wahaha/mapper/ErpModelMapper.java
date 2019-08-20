package wahaha.mapper;

import wahaha.model.ErpModel;

import java.util.List;

public interface ErpModelMapper {
    List<ErpModel> findAllModel(String staName);
    List<ErpModel> getModel(String roleId);
    List<ErpModel> finModel();
    List<ErpModel> getErpModel();
    List<ErpModel> findAll(ErpModel staff);

    List<ErpModel> findSubModel(String modelId);

    int insertSelective(ErpModel staff);
    int updateByPrimaryKeySelective(ErpModel staff);


}
