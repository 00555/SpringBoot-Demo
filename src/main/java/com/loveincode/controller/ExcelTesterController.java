package com.loveincode.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.loveincode.model.Person;
import com.loveincode.service.impl.PersonServiceImpl;
import com.loveincode.utils.ExcelUtils;
@RestController
@RequestMapping("/excel")
public class ExcelTesterController {
	@Resource 
	PersonServiceImpl personService;
	
	@PostMapping("/export")
	public void exportAll(HttpServletResponse response) {
		List<Person> all = personService.findAll();
		ExcelUtils.exportExcel(all, "All persons", "test", Person.class, "person file", true, response);
	}
	@PostMapping("/import")
	public void importBatch(@RequestParam("file") MultipartFile file) {
		System.out.println(file.getContentType());
		List<Person> persons = ExcelUtils.importExcel(file, 1, 1, Person.class);
		personService.save(persons);
	}

}
