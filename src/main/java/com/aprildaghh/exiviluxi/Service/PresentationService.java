package com.aprildaghh.exiviluxi.Service;

import com.aprildaghh.exiviluxi.Dao.PresentationDao;
import com.aprildaghh.exiviluxi.Model.PresentationEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PresentationService {

    @Autowired
    private PresentationDao presentationDao;


    public void addPresentation(PresentationEntity presentation)
    {
        presentationDao.createPresentation(presentation);
    }


    public PresentationEntity getSinglePresentation(int presentation_id)
    {
        return presentationDao.readById(presentation_id);
    }

}
