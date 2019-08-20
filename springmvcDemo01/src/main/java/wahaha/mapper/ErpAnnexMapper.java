package wahaha.mapper;

import wahaha.model.ErpAnnex;

import java.util.List;

public interface ErpAnnexMapper {
    /**
     * 查询所有isva为1的数据
     * @return
     */
    public List<ErpAnnex> getAnnex();
}
