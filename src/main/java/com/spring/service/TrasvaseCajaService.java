package com.spring.service;

import com.spring.pojos.SbTrasvaseCajaCab;
import com.spring.pojos.SbTrasvaseCajaDeta;
import java.util.List;


public interface TrasvaseCajaService {

   List<SbTrasvaseCajaDeta> listTravaseCajaDeta(Long idtrasvase);
   void saveTrasvaseCajaCab(SbTrasvaseCajaCab sbTrasvase);
   void saveTrasvaseCajaDeta(SbTrasvaseCajaDeta sbTrasvasedeta);
}
