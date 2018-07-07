package br.com.caelum.ingresso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.model.Filme;

@RestController
public class FilmeRestController {

	@Autowired
    private FilmeDao filmeDao;
	  
    @RequestMapping(value="/filme/em-cartaz-json", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Filme> emCartazJson(){
    	return filmeDao.findAll();
    }
}
