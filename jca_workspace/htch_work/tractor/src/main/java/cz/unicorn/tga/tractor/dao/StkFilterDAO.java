package cz.unicorn.tga.tractor.dao;

import java.util.List;

import cz.unicorn.tga.tractor.entity.Stk;
import cz.unicorn.tga.tractor.model.StkFilter;

public interface StkFilterDAO extends GenericDAO<Stk,Long> {

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    List<Stk> findByFilter(final StkFilter filter);
}