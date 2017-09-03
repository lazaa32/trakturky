package cz.unicorn.tga.tractor.dao;

import java.util.List;

import cz.unicorn.tga.tractor.entity.Lending;
import cz.unicorn.tga.tractor.model.LendingFilter;

public interface LendingFilterDAO extends GenericDAO<Lending,Long> {

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    List<Lending> findByFilter(final LendingFilter filter);
}
