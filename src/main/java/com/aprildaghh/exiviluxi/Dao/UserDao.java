package com.aprildaghh.exiviluxi.Dao;

import com.aprildaghh.exiviluxi.Model.UserEntity;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public UserEntity readById(int id) {

        Session session = sessionFactory.getCurrentSession();

        Query<UserEntity> query = session.createQuery("""
                select * from UserEntity u were u.id = :id
                """, UserEntity.class)
                .setParameter("id", id);

        return query.getSingleResult();
    }

    @Transactional
    public void put(UserEntity user) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("""
                update UserEntity(username, password) values
                ( :username , :password ) where UserEntity.id = :id
                """)
                .setParameter("id", user.getId())
                .setParameter("username", user.getUsername())
                .setParameter("password", user.getPassword());

        query.executeUpdate();

    }

    @Transactional
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("""
                delete from UserEntity where UserEntity.id = :id
                """)
                .setParameter(":id", id);

        query.executeUpdate();

    }

    @Transactional
    public void create(UserEntity user) {

        Session session = sessionFactory.getCurrentSession();

        // save intention to db
        Query query = session.createQuery(
                        """
                                insert into UserEntity(username, password)
                                values ( :username , :password )
                                """)
                .setParameter("username", user.getUsername())
                .setParameter("password", user.getPassword());

        query.executeUpdate();

    }
}
