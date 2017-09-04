package cz.unicorn.tga.tractor.dao;

import cz.unicorn.tga.tractor.entity.Stk;
import cz.unicorn.tga.tractor.model.StkFilter;
import cz.unicorn.tga.tractor.util.QueryBuilder;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StkFilterDAOImpl extends GenericHibernateDAO<Stk,Long> implements StkFilterDAO {
    @Override
    public List<Stk> findByFilter(StkFilter filter) {
        final Query query = createQueryFromCarFilter(filter);
        return query.list();
    }

    private Query createQueryFromCarFilter(final StkFilter filter) {
        final QueryBuilder builder = new QueryBuilder(getSession(), "SELECT s FROM Stk s WHERE 1 = 1");

        builder.appendIfNotNull("AND s.id = :id", "id", filter.getId());
        builder.appendIfNotNull("AND s.car = :car", "car", filter.getCar());

        return builder.build();
    }
}
