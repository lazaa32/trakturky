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
public class LendingManagerServiceBean implements LendingManagerService {

    private final LendingDAO lendingDAO;
    private final DTOMapper dtoMapper;

    @Autowired public LendingManagerServiceBean(LendingDAO lendingDAO, DTOMapper dtoMapper) {
        this.lendingDAO = lendingDAO;
        this.dtoMapper = dtoMapper;
    }

    /** {@inheritDoc} */
    @Override
    public List<LendingDTO> getAllLendings() {
        return dtoMapper.convertLending(lendingDAO.findAll());
    }
}
