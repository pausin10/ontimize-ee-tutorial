package com.imatia.jee.bankmanager.server.services;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imatia.jee.bankmanager.common.base.services.ICustomerService;
import com.imatia.jee.bankmanager.server.dao.CustomerDao;
import com.imatia.jee.bankmanager.server.dao.CustomerTypeDao;
import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import com.ontimize.util.remote.BytesBlock;

@Service("CustomerService")
public class CustomerService implements ICustomerService {

 /** The user roles dao. */
 @Autowired private CustomerDao customerDao;

 @Autowired private CustomerTypeDao customerTypeDao;

 /** The DAO helper. */
 @Autowired private DefaultOntimizeDaoHelper daoHelper;

 // ---- CUSTOMER ----

 @Override
 public EntityResult customerQuery(Map<String, Object> keysValues, List<String> attributes) throws OntimizeJEERuntimeException {
  return this.daoHelper.query(this.customerDao, keysValues, attributes);
 }

 @Override
 @Transactional(rollbackFor = Exception.class)
 public EntityResult customerInsert(Map<String, Object> attributes) throws OntimizeJEERuntimeException {
  return this.daoHelper.insert(this.customerDao, attributes);
 }

 @Override
 @Transactional(rollbackFor = Exception.class)
 public EntityResult customerUpdate(Map<String, Object> attributes, Map<String, Object> keyValues) throws OntimizeJEERuntimeException {
  return this.daoHelper.update(this.customerDao, attributes, keyValues);
 }

 @Override
 @Transactional(rollbackFor = Exception.class)
 public EntityResult customerDelete(Map<String, Object> keyValues) throws OntimizeJEERuntimeException {
  return this.daoHelper.delete(this.customerDao, keyValues);
 }

 // ---- CUSTOMER TYPE ----

 @Override
 public EntityResult customerTypeQuery(Map<String, Object> keysValues, List<String> attributes) throws OntimizeJEERuntimeException {
  return this.daoHelper.query(this.customerTypeDao, keysValues, attributes);
 }

 @Override
        @Transactional(rollbackFor = Exception.class)
 public EntityResult customerTypeInsert(Map<String, Object> attributes) throws OntimizeJEERuntimeException {
  return this.daoHelper.insert(this.customerTypeDao, attributes);
 }

 @Override
        @Transactional(rollbackFor = Exception.class)
 public EntityResult customerTypeUpdate(Map<String, Object> keyValues, Map<String, Object> attributes) throws OntimizeJEERuntimeException {
  return this.daoHelper.update(this.customerTypeDao, keyValues, attributes);
 }

 @Override
        @Transactional(rollbackFor = Exception.class)
 public EntityResult customerTypeDelete(Map<String, Object> keyValues) throws OntimizeJEERuntimeException {
  return this.daoHelper.delete(this.customerTypeDao, keyValues);
 }
}