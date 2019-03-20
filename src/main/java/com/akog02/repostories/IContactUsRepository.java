package com.akog02.repostories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akog02.domain.ContactUs;
@Repository
public interface IContactUsRepository extends CrudRepository<ContactUs,Integer>{
//Customize code will be here.
}
