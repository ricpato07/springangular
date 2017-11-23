package com.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.pojos.SbTrasvaseCajaCab;
import com.spring.pojos.SbTrasvaseCajaDeta;
import com.spring.service.TrasvaseCajaService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TrasvaseCajaController {

    @Autowired
    private TrasvaseCajaService trasvasecajaService;

    @RequestMapping(value = "/trasvasecajacab", method = RequestMethod.POST)
    private ResponseEntity<?> saveTrasvaseCajaCab(@RequestBody SbTrasvaseCajaCab sbTrasvasecajacab) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            trasvasecajaService.saveTrasvaseCajaCab(sbTrasvasecajacab);
            return new ResponseEntity<String>(mapper.writeValueAsString(sbTrasvasecajacab), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error method:" + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
    
    @RequestMapping(value = "/trasvasecajadeta", method = RequestMethod.POST)
    private ResponseEntity<?> saveTrasvaseCajaDeta(@RequestBody SbTrasvaseCajaDeta trasvaseCajaDeta) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            trasvasecajaService.saveTrasvaseCajaDeta(trasvaseCajaDeta);
            return new ResponseEntity<String>(mapper.writeValueAsString(trasvaseCajaDeta), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error method:" + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
    
    @RequestMapping(value = "/trasvasecajadeta/{id}", method = RequestMethod.GET)
    private ResponseEntity<?> listTrasvaseCajaDeta(@PathVariable("id") long idtrasvase) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<SbTrasvaseCajaDeta> result = trasvasecajaService.listTravaseCajaDeta(idtrasvase);

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
       
}
