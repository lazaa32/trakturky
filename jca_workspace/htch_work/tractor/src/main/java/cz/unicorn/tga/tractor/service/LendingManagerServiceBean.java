/**
 *
 */
package cz.unicorn.tga.tractor.service;

import java.util.Date;
import java.util.List;

import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.entity.Client;
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
    private final CarDAO carDAO;
    private final DTOMapper dtoMapper;
    private final ClientDAO clientDAO;

    @Autowired public LendingManagerServiceBean(ClientDAO clientDAO, CarDAO carDAO, LendingDAO lendingDAO, LendingFilterDAO filterDAO, DTOMapper dtoMapper) {
        this.lendingDAO = lendingDAO;
        this.filterDAO = filterDAO;
        this.dtoMapper = dtoMapper;
        this.carDAO = carDAO;
        this.clientDAO = clientDAO;
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
    public void save(NewLendingDTO newLen) {
        Lending lend = new Lending();
        Client client = clientDAO.findOne(newLen.getClient());
        Car car = carDAO.findOne(newLen.getCar());

        lend.setCar(car);
        lend.setClient(client);
        lend.setDateFrom(newLen.getDateFrom());
        lend.setDateTo(newLen.getDateTo());
        lend.setPrice(newLen.getPrice());
        lend.setLattitude(newLen.getLattitude());
        lend.setLongitude(newLen.getLongitude());

        lendingDAO.save(lend);
    }
}
