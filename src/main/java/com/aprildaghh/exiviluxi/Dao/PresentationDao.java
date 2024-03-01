package com.aprildaghh.exiviluxi.Dao;

import com.aprildaghh.exiviluxi.Model.PresentationEntity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PresentationDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public PresentationEntity readById(int presentationId) {
        return entityManager.find(PresentationEntity.class, presentationId);
    }

    @Transactional
    public void createPresentation(PresentationEntity presentation) {
        entityManager.merge(presentation);
    }
}
