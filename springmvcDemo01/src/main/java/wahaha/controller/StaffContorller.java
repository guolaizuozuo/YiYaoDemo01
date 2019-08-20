package wahaha.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import wahaha.model.ErpStaff;
import wahaha.service.ErpStaff.ErpStaffService;
import wahaha.util.PagelayBean;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * 员工信息
 */

@Controller
@RequestMapping("/admin/staff")
public class StaffContorller {
    @Autowired
    private ErpStaffService staffService;

    @RequestMapping("index.action")
    public String StaffIndex() {
        System.out.println("1111111");
        return "view/staff/index";
    }


    /**
     * 获取用户列表
     *
     * @param staff
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("findAll")
    public PagelayBean<ErpStaff> findAll(ErpStaff staff, int page, int limit) {
       /* Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("搜索框中的值为："+staff.getRoleName());
        Pages pages = new Pages();
        pages.setCurPage(page);
        pages.setMaxResult(limit);
        staff.setPage(pages.getFirstRows());
        staff.setLimit(limit);*/
        PagelayBean<ErpStaff> pagelayBean = new PagelayBean<ErpStaff>();

        PageHelper.startPage(page,5);
        List<ErpStaff> list = staffService.findAll(staff);
        PageInfo<ErpStaff> pageInfo = new PageInfo<ErpStaff>(list);

        pagelayBean.setCode(0);
        pagelayBean.setMsg("");
        pagelayBean.setCount(pageInfo.getTotal());
        pagelayBean.setData(pageInfo.getList());

        return pagelayBean;

    }


    /**
     * 用户上传头像
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("updateEmpPhoto.action")
    @ResponseBody  //ajax注解
    public String updateEmpPhoto(@RequestParam(value = "file", required = false) MultipartFile file,
                                 HttpServletRequest request) throws IOException {
        String id = request.getParameter("id");
        ErpStaff staff = new ErpStaff();
        staff.setStaId(id);
        staffService.updateEmpPhoto(staff,"/upload",file);
        return "result";
    }
}
