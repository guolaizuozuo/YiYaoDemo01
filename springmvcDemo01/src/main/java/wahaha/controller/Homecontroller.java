package wahaha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import wahaha.model.ErpModel;
import wahaha.model.ErpStaff;
import wahaha.service.ErpModel.ErpModelService;
import wahaha.service.ErpStaff.ErpStaffService;
import wahaha.util.SsmMessage;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class Homecontroller {

    @Resource
    private ErpStaffService staffService;
    @Resource
    private ErpModelService modelService;


    @RequestMapping(value = {"login.action"})
    public String handleRequest() throws Exception {
        return "view/admin/login";
    }

    @RequestMapping("loginSubmit.action")
    @ResponseBody
    public SsmMessage login(ErpStaff staff, HttpServletRequest request, HttpSession session, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入方法"+staff.getStaEmail()+"               "+staff.getStaPwd());
        ErpStaff rows = staffService.getUser(staff);
        SsmMessage mes = new SsmMessage();
        if(rows!=null){
            session.setAttribute("staff", rows);
            mes.setMes("ok");
            return mes;
        }else{
            System.out.println("error");
            mes.setMes("no");
            return mes;
        }

    }

    @RequestMapping("/")
    public ModelAndView findAllModel(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException{
        ErpStaff staff = (ErpStaff) session.getAttribute("staff");
        if(staff!=null){
            List<ErpModel> list = modelService.findAllModel(staff.getStaEmail());
            List<ErpModel>list2 = modelService.getModel(staff.getRoleId());
            request.setAttribute("model", list);
            request.setAttribute("modelSub", list2);
            ModelAndView view = new ModelAndView("view/admin/homePage");
            return view;
        }else{
            return null;
        }


    }
}
