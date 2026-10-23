package com.eletra.repository;

import com.eletra.model.CategoryEntity;
import com.eletra.util.HibernateUtil;
import org.hibernate.Session;
import java.util.Collections;
import java.util.List;

public class CategoryRepository {
    public List<CategoryEntity> findByLineId(Integer lineId) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session
                    .createQuery("FROM CategoryEntity c WHERE c.line.id = :lineId ORDER BY c.id", CategoryEntity.class)
                    .setParameter("lineId", lineId)
                    .getResultList();
        } catch(Exception e) {
            e.printStackTrace(System.err);
            return Collections.emptyList();
        }
    }
}
