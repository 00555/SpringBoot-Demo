package com.loveincode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.loveincode.model.Person;
import com.loveincode.service.impl.PersonServiceImpl;

import tk.mybatis.mapper.entity.Condition;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

	@Autowired
	private PersonServiceImpl personService;
	@Test
	public void contextLoads() {
	}

	@Test
	public void saveOne() {
		Person newPerson = new Person();
		newPerson.setAge(10);
		newPerson.setBirth(new Date());
		newPerson.setName("loveincode");
		newPerson.setSex("man");
		personService.save(newPerson);
	}
	@Test
	public void saveMore() {
		List<Person> personList = new ArrayList<>();
		for(int i=0; i < 5; i++) {
			Person newPerson = new Person();
			newPerson.setAge(10+i);
			newPerson.setBirth(new Date());
			newPerson.setName("loveincode"+i);
			newPerson.setSex("man"+i);
			personList.add(newPerson);
		}
		personService.save(personList);
	}
	
	@Test
	public void deleteById() {
		personService.deleteById(1);
	}
	
	@Test 
	public void deleteByIds() {
		personService.deleteByIds("2,3,4,5");
	}
	
	@Test
	public void updateById() {
		Person upPerson = new Person();
		upPerson.setId(6);
		upPerson.setAge(1000);
		upPerson.setBirth(new Date());
		upPerson.setName("happy May day.");
		personService.update(upPerson);
	}
	
	@Test
	public void findByCondition() {
		Condition con = new Condition(Person.class);
		con.createCriteria().andCondition("name like '%loveincode%'");
		con.setOrderByClause("name desc");
		List<Person> conPersons = personService.findByCondition(con);
		for(int i=0; i<conPersons.size();i++) {
			System.out.println("===Condition persons===:" + conPersons.get(i).getName());
		}
	}
	
	@Test
	public void findALl() {
		List<Person> all = personService.findAll();
		for(int i=0; i<all.size();i++) {
			System.out.println("===Query all persons===" + all.get(i).getName());
		}
	}
	
	@Test
	public void findByIds() {
		List<Person> byIds = personService.findByIds("2,3,4,5");
		for(int i=0; i<byIds.size();i++) {
			System.out.println("===find by ids===" + byIds.get(i).getName());
		}
	}
	
	@Test
	public void findBy() {
		Person p = personService.findBy("name", "loveincode1");
		System.out.println("===find by field==="+p.getId());
	}

}
