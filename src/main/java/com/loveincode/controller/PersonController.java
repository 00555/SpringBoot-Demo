package com.loveincode.controller;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loveincode.common.Result;
import com.loveincode.common.ResultGenerator;
import com.loveincode.model.Person;
import com.loveincode.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	private final static Logger logger = LoggerFactory.getLogger(PersonController.class);
	
    @Resource
    private PersonService personService;

    @RequestMapping(method = RequestMethod.POST)
    public Result add(Person person) {
    	logger.info(person.toString());
        personService.save(person);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable Integer id) {
        personService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable String id,Person person) {
        personService.update(person);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result queryDetail(@PathVariable Integer id) {
    	logger.info("=============start to query person's detail.===============");
        Person person = personService.findById(id);
        return ResultGenerator.genSuccessResult(person);
    }

    @RequestMapping(value = "/personlist", method = RequestMethod.GET)
    public Result queryList(
    		@RequestParam(defaultValue = "0") Integer page, 
    		@RequestParam(defaultValue = "0") Integer size){
        PageHelper.startPage(page, size);
        List<Person> list = personService.findAll();
        PageInfo<Person> pageInfo = new PageInfo<Person>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    
    @PostMapping("/exception")
    public Result exception() {
    	throw new RuntimeException("自定義異常.");
    }
}
