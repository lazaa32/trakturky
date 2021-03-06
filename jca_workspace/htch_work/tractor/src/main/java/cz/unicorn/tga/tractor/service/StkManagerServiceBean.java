/**
 *
 */
package cz.unicorn.tga.tractor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.unicorn.tga.tractor.dao.*;
import cz.unicorn.tga.tractor.model.*;
import cz.unicorn.tga.tractor.util.*;

/**
 * @author DZCJS9F
 *
 */
@Service
@Transactional
public class StkManagerServiceBean implements StkManagerService {

    private final StkDAO stkDAO;
    private final DTOMapper dtoMapper;
    private final StkFilterDAO stkFilterDAO;

    @Autowired public StkManagerServiceBean(StkDAO stkDAO, StkFilterDAO stkFilterDAO, DTOMapper dtoMapper) {
        this.stkDAO = stkDAO;
        this.dtoMapper = dtoMapper;
        this.stkFilterDAO = stkFilterDAO;
    }

    /** {@inheritDoc} */
    @Override
    public List<StkDTO> getAllStks() {
        return dtoMapper.convertStk(stkDAO.findAll());
    }

    @Override
    public List<StkDTO> findStksByFilter(StkFilter stkFilter) {
        return dtoMapper.convertStk(stkFilterDAO.findByFilter(stkFilter));
    }
}
