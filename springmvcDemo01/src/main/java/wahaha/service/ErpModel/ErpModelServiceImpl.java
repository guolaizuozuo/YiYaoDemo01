package wahaha.service.ErpModel;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import wahaha.mapper.ErpModelMapper;
import wahaha.model.ErpModel;
import wahaha.util.PagelayBean;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class ErpModelServiceImpl implements ErpModelService {

    @Resource
    private ErpModelMapper dao;

    @Override
    public List<ErpModel> findAllModel(String staName) {
        return dao.findAllModel(staName);
    }

    @Override
    public List<ErpModel> getModel(String roleId) {
        return dao.getModel(roleId);
    }

    @Override
    public List<ErpModel> finModel() {
        return dao.finModel();

    }

    @Override
    public List<ErpModel> getErpModel() {
        return dao.getErpModel();
    }

    @Override
    public PagelayBean<ErpModel> findAll(ErpModel model,int page, int limit) {


        PagelayBean<ErpModel> pagelayBean = new PagelayBean<ErpModel>();

        PageHelper.startPage(page, limit);
        List<ErpModel> list = dao.findAll(model);
        PageInfo<ErpModel> pageInfo = new PageInfo<ErpModel>(list);

        pagelayBean.setCode(0);
        pagelayBean.setMsg("");
        pagelayBean.setCount(pageInfo.getTotal());
        pagelayBean.setData(pageInfo.getList());
        return pagelayBean;
    }

    @Override
    public List<ErpModel> findSubModel(String modelId) {
        return dao.findSubModel(modelId);
    }

    @Override
    public int addBelowModel(String modelId, String[] modelName, String[] modelCode) {
       int result=0;
        for(int i =0;i<modelName.length;i++){
            if(modelName[i]!=""){
                ErpModel model = new ErpModel();
                model.setModelId(UUID.randomUUID().toString());
                model.setIsva("1");
                model.setModelCode(modelCode[i]);
                model.setModelName(modelName[i]);
                model.setErpModelId(modelId);
                dao.insertSelective(model);
                result++;
            }
        }
        return result;
    }

    @Override
    public int updateByPrimaryKeySelective(String[] modelId, String[] modelName, String[] modelCode) {
        int result=0;
        for(int i =0;i<modelName.length;i++){
            if(modelName[i]!=""){
                ErpModel model = new ErpModel();


                model.setModelCode(modelCode[i]);
                model.setModelName(modelName[i]);
                model.setModelId(modelId[i]);
                result+=  dao.updateByPrimaryKeySelective(model);

            }
        }
        return result;
    }
}
