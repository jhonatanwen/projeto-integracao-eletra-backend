package com.eletra.repository;

import com.eletra.model.LineEntity;
import com.eletra.util.HibernateUtil;
import org.hibernate.Session;
import java.util.Collections;
import java.util.List;

public class LineRepository {
    public List<LineEntity> findAll() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session
                    .createQuery("FROM LineEntity ORDER BY id", LineEntity.class)
                    .getResultList();
        } catch(Exception e) {
            e.printStackTrace(System.err);
            return Collections.emptyList();
        }
    }

    public LineEntity findByName(String name) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session
                    .createQuery("FROM LineEntity l WHERE LOWER(l.name) = LOWER(:name)", LineEntity.class)
                    .setParameter("name", name)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return null;
        }
    }
}
