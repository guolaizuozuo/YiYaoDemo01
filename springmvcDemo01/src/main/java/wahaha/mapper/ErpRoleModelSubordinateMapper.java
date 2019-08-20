package wahaha.mapper;

import org.apache.ibatis.annotations.Param;
import wahaha.model.ErpRoleModelSubordinate;

import java.util.List;

public interface ErpRoleModelSubordinateMapper {
    int deleteByPrimaryKey(String subId);

    //传统的单添加方法 ，后来改成下面的批处理删除
    int insertSelective(ErpRoleModelSubordinate record);
    int insertBatchSelective(@Param("RoleModes") List<ErpRoleModelSubordinate> record);
}
