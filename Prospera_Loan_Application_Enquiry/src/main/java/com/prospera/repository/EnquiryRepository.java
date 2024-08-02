package com.prospera.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prospera.model.Enquiry;
@Repository
public interface EnquiryRepository extends CrudRepository<Enquiry, Integer>{

}
