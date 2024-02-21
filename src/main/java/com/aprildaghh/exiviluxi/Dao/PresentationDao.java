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
        Session session = sessionFactory.openSession();

        Query<PresentationEntity> query = session.createQuery("""
                from PresentationEntity PE where PE.id = :id
                """, PresentationEntity.class)
                .setParameter("id", presentationId);

        return query.getSingleResult();
    }

    @Transactional
    public void put(PresentationEntity presentationEntity) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("""
                update PresentationEntity(date, password, user, videoUrl, backgroundColor, backgroundUrl) values
                ( :date , :password , :user , :video_url , :background_color , :background_url ) where PresentationEntity.id = :id
                """)
                .setParameter("id", presentationEntity.getId())
                .setParameter("date", presentationEntity.getDate())
                .setParameter("password", presentationEntity.getPassword())
                .setParameter("video_url", presentationEntity.getVideoUrl())
                .setParameter("background_color", presentationEntity.getBackgroundColor())
                .setParameter("background_url", presentationEntity.getBackgroundUrl())
                .setParameter("user", presentationEntity.getUser());

        query.executeUpdate();
    }

    @Transactional
    public void create(PresentationEntity presentation) {

        Session session = sessionFactory.getCurrentSession();

        // save intention to db
        Query query = session.createQuery(
                        """
                                insert into PresentationEntity(date, password, user, videoUrl, backgroundColor, backgroundUrl)
                                values ( :date , :password , :user , :video_url , :background_color , :background_url )
                                """)
                .setParameter("date", presentation.getDate())
                .setParameter("password", presentation.getPassword())
                .setParameter("video_url", presentation.getVideoUrl())
                .setParameter("background_color", presentation.getBackgroundColor())
                .setParameter("background_url", presentation.getBackgroundUrl())
                .setParameter("user", presentation.getUser());

        query.executeUpdate();

    }
}
