package wahaha.mapper;

import wahaha.model.ErpStaff;

import java.util.List;

public interface ErpStaffMapper {
    ErpStaff getUser(ErpStaff record);

    List<ErpStaff> findAll(ErpStaff staff);

    int updateEmpPhoto(ErpStaff record);
}
