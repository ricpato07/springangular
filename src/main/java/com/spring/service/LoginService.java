package com.spring.service;

import com.adeadms.core.security.pojos.UsuarioWebmx;
import com.spring.pojos.SbTrasvase;
import com.spring.pojos.Usuarios;
import java.util.List;


public interface LoginService {

    UsuarioWebmx validarAcceso(String user, String pass);
    List<Usuarios> getUsers();
    Usuarios getUserLogin(String usuario, String password);
    void saveTrasvase(SbTrasvase sbTrasvase);
    void updateTrasvase(SbTrasvase sbTrasvase);
    List<SbTrasvase> listTravase(Long caja);
}
