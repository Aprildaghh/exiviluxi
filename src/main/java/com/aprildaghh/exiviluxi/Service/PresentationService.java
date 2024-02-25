package com.aprildaghh.exiviluxi.Service;

import com.aprildaghh.exiviluxi.Dao.PresentationDao;
import com.aprildaghh.exiviluxi.Dao.UserDao;
import com.aprildaghh.exiviluxi.Model.PresentationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresentationService {

    private UserDao userDao;
    private PresentationDao presentationDao;

    @Autowired
    public PresentationService(UserDao userDao, PresentationDao presentationDao) {
        this.userDao = userDao;
        this.presentationDao = presentationDao;
    }

    public List<PresentationEntity> getPresentationsByUser(int user_id)
    {
        return userDao.readById(user_id).getPresentations();
    }

    public int addPresentation(PresentationEntity presentation)
    {
        return presentationDao.create(presentation);
    }

    public void deletePresentation(int presentation_id)
    {
        presentationDao.deletePresentationById(presentation_id);
    }

    public PresentationEntity getSinglePresentation(int presentation_id)
    {
        return presentationDao.readById(presentation_id);
    }

    public void updatePresentation(PresentationEntity presentationEntity)
    {
        presentationDao.put(presentationEntity);
    }


}
