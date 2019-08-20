package wahaha.service.ErpStaff;

import org.springframework.web.multipart.MultipartFile;
import wahaha.model.ErpStaff;

import java.io.IOException;
import java.util.List;

public interface ErpStaffService {

    ErpStaff getUser(ErpStaff staff);

    List<ErpStaff> findAll(ErpStaff staff);

   String updateEmpPhoto( ErpStaff staff,String webPath,MultipartFile file) throws IOException;
}
