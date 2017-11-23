package com.spring.service.impl;

import com.spring.pojos.SbTrasvase;
import com.spring.pojos.SbTrasvaseCajaCab;
import com.spring.pojos.SbTrasvaseCajaDeta;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.spring.service.TrasvaseCajaService;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class TrasvaseCajaServiceImpl implements TrasvaseCajaService {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public List<SbTrasvaseCajaDeta> listTravaseCajaDeta(Long idtrasvase) {
        try {
            String query = "SELECT * FROM RGARCIAU.SB_TRASVASE_CAJA_DETA WHERE IDTRASVASE = ?";
            SQLQuery SQLquery = getSession().createSQLQuery(query);
            SQLquery.addEntity(SbTrasvaseCajaDeta.class);
            SQLquery.setParameter(0, idtrasvase);
            List<SbTrasvaseCajaDeta> result = SQLquery.list();

            if (result != null && result.size() > 0) {
                return result;
            }

        } catch (Exception e) {
            System.out.println("Error en el DAO: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public void saveTrasvaseCajaCab(SbTrasvaseCajaCab sbTrasvase) {
        sbTrasvase.setIdtrasvase(maxTravaseCajaCab());
        getSession().persist(sbTrasvase);
    }

    @Override
    @Transactional
    public void saveTrasvaseCajaDeta(SbTrasvaseCajaDeta sbTrasvasedeta) {
        getSession().persist(sbTrasvasedeta);
    }
    
    @Transactional
    public Long maxTravaseCajaCab() {
        try {
            String query = "SELECT MAX(IDTRASVASE)MAX FROM RGARCIAU.SB_TRASVASE_CAJA_CAB";
            SQLQuery SQLquery = getSession().createSQLQuery(query);
            List<?> result = SQLquery.list();

            if (result != null && result.size() > 0) {
                return Long.parseLong(result.get(0).toString());
            }

        } catch (Exception e) {
            System.out.println("Error en el DAO: " + e.getMessage());
            e.printStackTrace();
        }
        return 1L;
    }

}
