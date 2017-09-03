/**
 *
 */
package cz.unicorn.tga.tractor.service;

import java.util.List;

import cz.unicorn.tga.tractor.model.*;

/**
 * @author DZCJS9F
 *
 */
public interface LendingManagerService {
    void save(LendingDTO lendingNewForm);
    List<LendingDTO> getAllLendings();
    List<LendingDTO> findLendingsByFilter(LendingFilter lendingFilter);
}
