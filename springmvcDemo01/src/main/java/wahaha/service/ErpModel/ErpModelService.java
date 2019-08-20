package wahaha.service.ErpModel;

import wahaha.model.ErpModel;
import wahaha.util.PagelayBean;

import java.util.List;

public interface ErpModelService {
    List<ErpModel> findAllModel (String staName);
    List<ErpModel> getModel (String roleId);
    List<ErpModel> finModel();

    /**
     * 获得
     * @return
     */
    List<ErpModel> getErpModel();
    PagelayBean<ErpModel> findAll(ErpModel model,int page, int limit);

    List<ErpModel> findSubModel(String modelId);

}
