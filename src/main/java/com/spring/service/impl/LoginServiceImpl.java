package com.spring.service.impl;

import com.adeadms.core.security.pojos.UsuarioWebmx;
import com.adeamx.persistencia.utilerias.SHA1;
import com.spring.pojos.SbTrasvase;
import com.spring.pojos.Usuarios;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.spring.service.LoginService;
import java.util.Date;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
     public UsuarioWebmx validarAcceso(String user, String pass) {

        try {
            UsuarioWebmx usuario = getUser(user);
            if (usuario != null) {
                if (usuario.getStatus() == 'A') {
                    String sha1Password = SHA1.encriptarBase64(pass);
                    if (usuario.getPassword().equals(sha1Password)) {
                        usuario.setIntentos(new Integer(0).shortValue());

                        if (usuario.getFechaVigencia() == null || usuario.getFechaVigencia().before(new Date())) {
                            if (usuario.getNoAcceso() == null) {
                                usuario.setNoAcceso(1l);
                            } else {
                                usuario.setNoAcceso(usuario.getNoAcceso() + 1);
                            }

                        } else {
                            throw new Exception("El usuario a expirado, favor de verificar vigencia.");
                        }
                        // rs = "El usuario a expirado, favor de verificar vigencia.";

                    } else {
                        usuario.setIntentos(new Integer(0+1).shortValue());
                        if (usuario.getIntentos() >= 3) {
                            usuario.setStatus('R');
                            usuario.setFecharevocado(new Date());
                            throw new Exception("Usuario revocado");
                            // rs = "Usuario revocado";
                        } else {
                            throw new Exception("Contraseña incorrecta");
                            //rs = "Contraseña incorrecta";
                        }
                    }
                } else if (usuario.getStatus() == 'R') {
                    throw new Exception("Usuario revocado");
                    //rs = "Usuario revocado";
                } else {
                    throw new Exception("Usuario incorrecto");
                    // rs = "Usuario incorrecto";
                }
            } else {
                //return null;
                throw new Exception("Usuario incorrecto o privilegios insuficientes");
                //rs = "Usuario incorrecto o privilegios insuficientes";
            }

            return usuario;

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
    
    private UsuarioWebmx getUser(String user) {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select * from mexweb.USUARIO_WEBMX");
            sql.append(" where LOGIN = ? ");
            SQLQuery SQLquery = getSession().createSQLQuery(sql.toString());
            SQLquery.addEntity(UsuarioWebmx.class);
             SQLquery.setParameter(0, user);
            List<UsuarioWebmx> result = SQLquery.list();

            if (result != null && result.size() > 0) {
                return result.get(0);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    @Transactional
    public List<Usuarios> getUsers() {
        try {
            String query = "SELECT * FROM RGARCIAU.USUARIOS";
            SQLQuery SQLquery = getSession().createSQLQuery(query);
            SQLquery.addEntity(Usuarios.class);
            List<Usuarios> result = SQLquery.list();

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
    public Usuarios getUserLogin(String usuario, String password) {
        try {
            String query = "SELECT * FROM RGARCIAU.USUARIOS WHERE USUARIO = ? AND PASSWORD = ?";
            SQLQuery SQLquery = getSession().createSQLQuery(query);
            SQLquery.addEntity(Usuarios.class);
            SQLquery.setParameter(0, usuario);
            SQLquery.setParameter(1, password);
            List<Usuarios> result = SQLquery.list();

            if (result != null && result.size() > 0) {
                return result.get(0);
            }

        } catch (Exception e) {
            System.out.println("Error en el DAO: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
     @Override
    @Transactional
    public List<SbTrasvase> listTravase(Long caja) {
        try {
            String query = "SELECT * FROM RGARCIAU.SB_TRASVASE WHERE CAJA_DESTINO = ?";
            SQLQuery SQLquery = getSession().createSQLQuery(query);
            SQLquery.addEntity(SbTrasvase.class);
            SQLquery.setParameter(0, caja);
            List<SbTrasvase> result = SQLquery.list();

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
    public void saveTrasvase(SbTrasvase sbTrasvase) {
        getSession().persist(sbTrasvase);
    }
    
     @Override
    @Transactional
    public void updateTrasvase(SbTrasvase sbTrasvase) {
        getSession().merge(sbTrasvase);
    }

}
