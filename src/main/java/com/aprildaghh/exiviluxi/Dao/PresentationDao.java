package com.aprildaghh.exiviluxi.Dao;

import com.aprildaghh.exiviluxi.Model.PresentationEntity;
import com.aprildaghh.exiviluxi.Model.UserEntity;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PresentationDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void deletePresentationById(int presentationId) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("""
                delete from PresentationEntity where PresentationEntity.id = :id
                """)
                .setParameter(":id", presentationId);

        query.executeUpdate();
    }

    @Transactional
    public PresentationEntity readById(int presentationId) {
        Session session = sessionFactory.getCurrentSession();

        Query<PresentationEntity> query = session.createQuery("""
                select * from PresentationEntity p were p.id = :id
                """, PresentationEntity.class)
                .setParameter("id", presentationId);

        return query.getSingleResult();
    }

    @Transactional
    public void put(PresentationEntity presentationEntity) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("""
                update PresentationEntity(date, password, user) values
                ( :date , :password , :user ) where PresentationEntity.id = :id
                """)
                .setParameter("id", presentationEntity.getId())
                .setParameter("date", presentationEntity.getDate())
                .setParameter("password", presentationEntity.getPassword())
                .setParameter("user", presentationEntity.getUser());

        query.executeUpdate();
    }

    @Transactional
    public void create(PresentationEntity presentation) {

        Session session = sessionFactory.getCurrentSession();

        // save intention to db
        Query query = session.createQuery(
                        """
                                insert into PresentationEntity(date, password, user)
                                values ( :date , :password , :user )
                                """)
                .setParameter("date", presentation.getDate())
                .setParameter("password", presentation.getPassword())
                .setParameter("user", presentation.getUser());

        query.executeUpdate();

    }
}
