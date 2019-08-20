package wahaha.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wahaha.model.ErpModel;
import wahaha.service.ErpModel.ErpModelService;
import wahaha.util.PagelayBean;
import wahaha.util.SsmMessage;

import java.util.List;

@Controller
@RequestMapping("/admin/model")
public class ModelController {
    @Autowired
    private ErpModelService modelService;

    @RequestMapping("index.action")
    public String Index() {
        return "view/model/index";
    }

    @RequestMapping("getErpModel.action")
    @ResponseBody
    public List<ErpModel> getErpModel() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ErpModel> list = modelService.getErpModel();
        String json = objectMapper.writeValueAsString(list);
        System.out.println("model          ：" + json);
        return list;
    }

    @RequestMapping("findAll.action")
    @ResponseBody
    public PagelayBean<ErpModel> findAll(ErpModel model, int page, int limit) throws JsonProcessingException {
        PagelayBean<ErpModel> pagelayBean = modelService.findAll(model, page, limit);

        return pagelayBean;
    }

    @RequestMapping("addBelow")
    public String addBelow(Model model, String modelId) {
        //  ModelAndView view = new ModelAndView("view/model/addBelow");
        List<ErpModel> list = modelService.findSubModel(modelId);
        model.addAttribute("model", list);
        model.addAttribute("modelId", modelId);

        /*转发到处理方法*/
        return "view/model/addBelow";

    }

    @RequestMapping(value = "addBelowModel.action")
    @ResponseBody
    public SsmMessage addBelowModel(String modelId, String[] modelName, String[] modelCode) {
        SsmMessage msg = new SsmMessage();

        int i = modelService.addBelowModel(modelId, modelName, modelCode);
        if (i > 0) {
            msg.setState(200);
            msg.setMes("添加成功");
            return msg;
        }
        msg.setState(500);
        msg.setMes("添加失败");
        return msg;


    }
    @ResponseBody
    @RequestMapping(value = "updateBelowModel.action", method = {RequestMethod.POST})
    public SsmMessage updateBelowModel(String modelId[], String[] modelName, String[] modelCode) {
        SsmMessage msg = new SsmMessage();

        int i = modelService.updateByPrimaryKeySelective(modelId, modelName, modelCode);
        if (i > 0) {
            msg.setState(200);
            msg.setMes("添加成功");
            return msg;
        }
        msg.setState(500);
        msg.setMes("添加失败");
        return msg;


    }


}
