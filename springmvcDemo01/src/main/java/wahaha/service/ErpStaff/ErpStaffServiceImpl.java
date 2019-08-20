package wahaha.service.ErpStaff;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import wahaha.mapper.ErpStaffMapper;
import wahaha.model.ErpStaff;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ErpStaffServiceImpl implements ErpStaffService {
    @Resource
    private ErpStaffMapper dao;
    @Override
    public ErpStaff getUser(ErpStaff staff) {
        return dao.getUser(staff);
    }

    @Override
    public List<ErpStaff> findAll(ErpStaff staff)
    {
        return dao.findAll(staff);
}

    @Override
    public String updateEmpPhoto( ErpStaff staff, String webPath,MultipartFile file) throws IOException {
        String path = null;
        //获取文件名
        String fileName = file.getOriginalFilename();
        String Suffix = fileName.substring(fileName.lastIndexOf("."));
        String newFile = UUID.randomUUID().toString() + Suffix;
    //一般情况下企业是都是以日期作为文件夹的
        String localPath = webPath+"/images/" + new SimpleDateFormat("yyyy/MM/dd/").format(new Date());

        HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String diskPath = request.getSession().getServletContext().getRealPath(localPath);
        File f = new File(diskPath);
        if (!f.exists()) {
            f.mkdirs();
        }
        localPath+=newFile;
        path = diskPath  + newFile;
        System.out.println("新图片："+localPath);
        file.transferTo(new File(path));
//更新数据库
        staff.setStaImg(localPath);
        dao.updateEmpPhoto (staff);

        return localPath;
    }
}
