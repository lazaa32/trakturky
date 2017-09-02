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
public class RepairManagerServiceBean implements RepairManagerService {

    private final RepairDAO repairDAO;
    private final DTOMapper dtoMapper;

    @Autowired public RepairManagerServiceBean(RepairDAO repairDAO, DTOMapper dtoMapper) {
        this.repairDAO = repairDAO;
        this.dtoMapper = dtoMapper;
    }

    /** {@inheritDoc} */
    @Override
    public List<RepairDTO> getAllRepairs() {
        return dtoMapper.convertRepair(repairDAO.findAll());
    }
}
