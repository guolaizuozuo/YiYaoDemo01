package wahaha.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wahaha.model.ErpModel;
import wahaha.model.ErpRole;
import wahaha.model.ErpRoleModel;
import wahaha.service.ErpModel.ErpModelService;
import wahaha.service.ErpRole.ErpRoleService;
import wahaha.service.ErpRoleModel.ErpRoleModelService;
import wahaha.service.ErpRoleModelSubordinate.ErpRoleModelSubordinateService;
import wahaha.util.Pages;
import wahaha.util.SsmMessage;
import wahaha.util.ZTree;

import javax.annotation.Resource;
import java.util.*;

@Controller
@RequestMapping("/admin/role")
public class RoleController {

    @Resource
    private ErpRoleService roleService;
    @Resource
    private ErpModelService modelService;

    @Resource
    private ErpRoleModelService roleModelService;

    @RequestMapping("index.action")
    public String index() {
        return "view/role/index";
    }

    @Resource
    private ErpRoleModelSubordinateService roleModelSubService;


    @RequestMapping("getRoleAll.action")
    @ResponseBody
    public Map<String, Object> findAll(ErpRole role, int page, int limit) {
        Map<String, Object> map = new HashMap<String, Object>();
        Pages pages = new Pages();
        pages.setCurPage(page);
        pages.setMaxResult(limit);
        role.setPage(pages.getFirstRows());
        role.setLimit(limit);
        List<ErpRole> list = roleService.findAllRole(role);
        map.put("count", roleService.findRowCount(role));
        map.put("data", list);
        map.put("code", 0);
        map.put("msg", "");
        return map;
    }

    @RequestMapping("getRole.action")
    @ResponseBody
    public List<ErpRole> getRole() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ErpRole> list = roleService.findAll();

        return list;
    }

    @RequestMapping("add.action")
    @ResponseBody
    public SsmMessage getRole(ErpRole role) {
        SsmMessage mes = new SsmMessage();
        if ("".equals(role.getRoleId()) || null == role.getRoleId()) {
            role.setRoleId(UUID.randomUUID().toString());
            role.setIsva("1");
            roleService.insertSelective(role);
            mes.setMes("add");
        } else {
            roleService.updateByPrimaryKeySelective(role);
            mes.setMes("update");
        }
        return mes;
    }

    @RequestMapping("editRoleModel.action")
    public String editRoleModel(String roleId) {
        return "view/role/editRoleModel";
    }


    //修改角色的菜单权限
    @RequestMapping("editRoleModelSubmit")
    @ResponseBody
    public SsmMessage editRoleModelSubmit(String modelId, String roleId, String modelSubId) {
        SsmMessage mes = new SsmMessage();
        String[] stringSplit = modelId.split(",");
        String[] stringSplit2 = modelSubId.split(",");
        System.out.println("stringSplit+++++++++++++++++++" + modelSubId + "         " + modelId);

        roleService.editRoleModelSubmit(roleId, stringSplit, stringSplit2);
        mes.setMes("ok");
        return mes;
    }


    @RequestMapping("getRoleValue.action")
    @ResponseBody
    public List<ZTree> getRoleValue(String roleId) {
        List<ZTree> tree = new ArrayList<ZTree>();
        List<ErpRole> list = roleService.getRoleValue(roleId);
        List<ErpModel> model = modelService.getModel(roleId);
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            ErpRole erpRole = (ErpRole) iterator.next();
            ZTree t = new ZTree();
            t.setId(erpRole.getModelId());
            t.setpId(erpRole.getErpModelId());
            t.setName(erpRole.getModelName());
            tree.add(t);
        }
        for (Iterator iterator = model.iterator(); iterator.hasNext(); ) {
            ErpModel erpModel = (ErpModel) iterator.next();
            for (int i = 0; i < tree.size(); i++) {
                if (tree.get(i).getId() == erpModel.getErpModelId() || tree.get(i).getId().equals(erpModel.getErpModelId())) {
                    ZTree t = new ZTree();
                    t.setId(erpModel.getModelId());
                    t.setName(erpModel.getModelName());
                    t.setpId(erpModel.getErpModelId());
                    tree.add(t);
                }
            }
        }
        return tree;
    }

    @RequestMapping("getModel")
    @ResponseBody
    public List<ZTree> getModel(String roleId) {
        List<ZTree> tree = new ArrayList<ZTree>();
        List<ErpModel> model = modelService.finModel();
        List<ErpModel> model2 = modelService.getModel(roleId);
        List<ErpRoleModel> model3 = roleModelService.getMessage(roleId);
        for (Iterator iterator = model.iterator(); iterator.hasNext(); ) {
            ErpModel erpModel = (ErpModel) iterator.next();
            ZTree t = new ZTree();
            t.setId(erpModel.getModelId());
            t.setpId(erpModel.getErpModelId());
            t.setName(erpModel.getModelName());
            for (Iterator iterator2 = model2.iterator(); iterator2.hasNext(); ) {
                ErpModel erpModel2 = (ErpModel) iterator2.next();
                if (erpModel.getModelId().equals(erpModel2.getModelId())) {
                    t.setChecked("true");
                }
            }
            for (Iterator iterator2 = model3.iterator(); iterator2.hasNext(); ) {
                ErpRoleModel erpRoleModel = (ErpRoleModel) iterator2.next();
                if (erpModel.getModelId().equals(erpRoleModel.getModelId())) {
                    t.setChecked("true");
                }
            }
            tree.add(t);

        }
        return tree;
    }

    @RequestMapping("deleteRole.action")
    @ResponseBody
    public SsmMessage deleteRole(String roleId) {
        SsmMessage msg = new SsmMessage();

        int id = roleService.deleteRole(roleId);
        if (id > 0) {
            msg.setState(200);
        } else {
            msg.setState(500);
        }
        return msg;
    }
}
