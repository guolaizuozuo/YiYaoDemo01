package wahaha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wahaha.model.ErpAnnex;
import wahaha.service.Annex.AnnexService;

import java.util.List;

/**
 * 分店管理3333444
 */
@Controller
@RequestMapping("/admin/annex")
public class AnnexController {

    @Autowired
    private AnnexService annexService;


    @ResponseBody
    @RequestMapping("getAnnexlist.action")
    public List<ErpAnnex> getAnnex(){
        List<ErpAnnex>list = annexService.getAnnexlist();
        return list;
    }
}
