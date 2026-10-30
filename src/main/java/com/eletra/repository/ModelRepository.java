package com.eletra.repository;

import com.eletra.model.ModelEntity;
import com.eletra.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import java.util.Collections;
import java.util.List;

@Repository
public class ModelRepository {
    public List<ModelEntity> findByCategoryId(Integer categoryId) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM ModelEntity m WHERE m.category.id = :categoryId ORDER BY m.id",ModelEntity.class)
                    .setParameter("categoryId", categoryId)
                    .getResultList();
        } catch(Exception e) {
            e.printStackTrace(System.err);
            return Collections.emptyList();
        }
    }

}
