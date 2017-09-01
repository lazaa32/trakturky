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
        final QueryBuilder builder = new QueryBuilder(getSession(), "SELECT s FROM car_stk s WHERE 1 = 1");

        builder.appendIfNotNull("AND s.id = :id", "id", filter.getId());

        return builder.build();
    }
/*
    public List<Stk> findAndOrderByCheck() {
        final Query query = createQueryOrder();
        return query.list();
    }

    private Query createQueryOrder() {
        final QueryBuilder builder = new QueryBuilder(getSession(),
                "SELECT s FROM car_stk s JOIN car c ON car.id = car_stk.car " +
                        "WHERE c.state LIKE 'BROKEN'" +
                        " OR c.state LIKE 'IN_GARAGE'" +
                        "OR c.state LIKE 'LENDED' " +
                        "OR c.state LIKE 'REGISTRED' " +
                        "ORDER BY s.dateOfCheck ASC");

        return builder.build();
    }*/

}
