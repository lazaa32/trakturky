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
public class ClientManagerServiceBean implements ClientManagerService {

    private final ClientDAO clientDAO;
    private final DTOMapper dtoMapper;

    @Autowired public ClientManagerServiceBean(ClientDAO clientDAO, DTOMapper dtoMapper) {
        this.clientDAO = clientDAO;
        this.dtoMapper = dtoMapper;
    }

    /** {@inheritDoc} */
    @Override
    public List<ClientDTO> getAllClients() {
        return dtoMapper.convertClient(clientDAO.findAll());
    }
}
