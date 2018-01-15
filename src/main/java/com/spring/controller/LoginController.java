package com.spring.controller;

import com.adeadms.core.security.pojos.UsuarioWebmx;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.pojos.SbTrasvase;
import com.spring.pojos.Usuarios;
import com.spring.service.LoginService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    private ResponseEntity<?> list() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<UsuarioWebmx> result = loginService.getUsers();

            if (result != null && result.size() > 0) {
                return new ResponseEntity<String>(mapper.writeValueAsString(result), HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println("Error method:" + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    
     @RequestMapping(value = "/user", method = RequestMethod.GET)
    private ResponseEntity<?> getUser(@RequestParam(value = "user") String user) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            
            UsuarioWebmx usuario = loginService.getUser(user);
                    
            if (usuario != null) {
                return new ResponseEntity<String>(mapper.writeValueAsString(usuario), HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println("Error method:" + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    private ResponseEntity<?> login(@RequestBody Usuarios usuarios) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            UsuarioWebmx cat = loginService.validarAcceso(usuarios.getUsuario(), usuarios.getPassword());
            if (cat != null) {
                return new ResponseEntity<String>(mapper.writeValueAsString(cat), HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println("Error method:" + e.getMessage());
            return new ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/trasvase", method = RequestMethod.POST)
    private ResponseEntity<?> saveTrasvase(@RequestBody SbTrasvase sbTrasvase) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            loginService.saveTrasvase(sbTrasvase);
            return new ResponseEntity<String>(mapper.writeValueAsString(sbTrasvase), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error method:" + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @RequestMapping(value = "/trasvase", method = RequestMethod.GET)
    private ResponseEntity<?> list(@RequestParam(value = "caja", required = true) Long caja) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<SbTrasvase> result = loginService.listTravase(caja);

            if (result != null && result.size() > 0) {
                return new ResponseEntity<String>(mapper.writeValueAsString(result), HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println("Error method:" + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/trasvase", method = RequestMethod.PUT, headers = "Accept=application/xml,application/json")
    @ResponseBody
    private String updateTrasvase(@RequestBody SbTrasvase sbTrasvase) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("PUT method");
        try {
            loginService.updateTrasvase(sbTrasvase);
            return mapper.writeValueAsString(new ResponseEntity<Object>(sbTrasvase, HttpStatus.OK));
        } catch (Exception e) {
            System.out.println("Error method:" + e.getMessage());
            return mapper.writeValueAsString(new ResponseEntity<Object>(HttpStatus.SERVICE_UNAVAILABLE));
        }
    }

}
