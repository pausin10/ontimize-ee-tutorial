package com.imatia.jee.bankmanager.server.services;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imatia.jee.bankmanager.common.base.services.IBranchService;
import com.imatia.jee.bankmanager.server.dao.BranchDao;
import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEEException;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("BranchService")
public class BranchService implements IBranchService{
	
	private static final Logger logger = LoggerFactory.getLogger(BranchService.class);
	
	@Autowired private BranchDao branchDao;
	@Autowired private DefaultOntimizeDaoHelper daoHelper;

	@Override
	public EntityResult branchQuery(Map<String, Object> keysValues, List<String> attributes)
			throws OntimizeJEEException {
		return this.daoHelper.query(this.branchDao, keysValues, attributes);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public EntityResult branchInsert(Map<String, Object> attributes) throws OntimizeJEERuntimeException {
		return this.daoHelper.insert(this.branchDao, attributes);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public EntityResult branchUpdate(Map<String, Object> attributes, Map<String, Object> keyValues)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(this.branchDao, attributes, keyValues);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public EntityResult branchDelete(Map<String, Object> keyValues) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.branchDao, keyValues);
	}
	
}
