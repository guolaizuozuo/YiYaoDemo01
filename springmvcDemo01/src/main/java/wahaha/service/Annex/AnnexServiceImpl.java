package wahaha.service.Annex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wahaha.mapper.ErpAnnexMapper;
import wahaha.model.ErpAnnex;

import java.util.List;

@Service
public class AnnexServiceImpl implements  AnnexService{

    @Autowired
    private ErpAnnexMapper annexMapper;

    @Override
    public List<ErpAnnex> getAnnexlist() {
        return annexMapper.getAnnex();
    }
}

