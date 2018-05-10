package com.loveincode.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loveincode.common.AbstractService;
import com.loveincode.mapper.PersonMapper;
import com.loveincode.model.Person;
import com.loveincode.service.PersonService;

import javax.annotation.Resource;


@Service
@Transactional
public class PersonServiceImpl extends AbstractService<Person> implements PersonService {
    @Resource
    private PersonMapper tPersonMapper;

}
