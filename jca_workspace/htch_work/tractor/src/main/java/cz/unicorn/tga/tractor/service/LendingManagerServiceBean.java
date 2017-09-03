/**
 *
 */
package cz.unicorn.tga.tractor.service;

import java.util.List;

import cz.unicorn.tga.tractor.entity.Lending;
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
public class LendingManagerServiceBean implements LendingManagerService {

    private final LendingDAO lendingDAO;
    private final LendingFilterDAO filterDAO;
    private final DTOMapper dtoMapper;

    @Autowired public LendingManagerServiceBean(LendingDAO lendingDAO, LendingFilterDAO filterDAO, DTOMapper dtoMapper) {
        this.lendingDAO = lendingDAO;
        this.filterDAO = filterDAO;
        this.dtoMapper = dtoMapper;
    }

    /** {@inheritDoc} */
    @Override
    public List<LendingDTO> getAllLendings() {
        return dtoMapper.convertLending(lendingDAO.findAll());
    }

    /** {@inheritDoc} */
    @Override
    public List<LendingDTO> findLendingsByFilter(final LendingFilter filter) {

        return dtoMapper.convertLending(filterDAO.findByFilter(filter));
    }

    @Override
    public void save(LendingDTO newLen) {
        lendingDAO.save(dtoMapper.convert2Lending(newLen));
    }
}
