package cz.unicorn.tga.tractor.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cz.unicorn.tga.tractor.entity.Lending;
import cz.unicorn.tga.tractor.model.LendingFilter;
import cz.unicorn.tga.tractor.util.QueryBuilder;

@Repository
public class LendingFilterDAOImpl extends GenericHibernateDAO<Lending,Long> implements LendingFilterDAO {

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    public List<Lending> findByFilter(final LendingFilter filter) {
        final Query query = createQueryFromCarFilter(filter);

        return query.list();
    }

    private Query createQueryFromCarFilter(final LendingFilter filter) {
        final QueryBuilder builder = new QueryBuilder(getSession(), "SELECT ln FROM Lending ln WHERE 1 = 1");

        builder.appendIfNotNull("AND ln.id = :id", "id", filter.getId());
        builder.appendIfNotNull("AND ln.car = :car", "car", filter.getCar());

        return builder.build();
    }

}
