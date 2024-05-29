package com.upt.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upt.dto.BranchDTO;


@Repository
public class BranchDAOImpl implements BranchDAOInt{

	private static Logger log = Logger.getLogger(BranchDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(BranchDTO dto) {
		log.info("BranchDAOImpl start method started");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long)session.save(dto);
		log.info("BranchDAOImpl Add method ends");
		return pk;
	}




	@Override
	public List<BranchDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<BranchDTO> list(int pageNo, int pageSize) {
		log.info("BranchDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<BranchDTO> query = session.createQuery("from BranchDTO", BranchDTO.class);
		List<BranchDTO> list = query.getResultList();
		log.info("BranchDAOImpl List method End");
		return list;
	}

	@Override
	public List<BranchDTO> search(BranchDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<BranchDTO> search(BranchDTO dto, int pageNo, int pageSize) {
		log.info("BranchDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(BranchDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("BranchDAOImpl Search method End");
		return criteria.list();
	}
	
	@Override
	@Transactional
	public void delete(BranchDTO dto) {
		Session session = entityManager.unwrap(Session.class);
		
		Query<BranchDTO> query = session.createSQLQuery("delete from c_branch where id = "+dto.getId()+"");
		
		query.executeUpdate();
		//entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));

	}




	@Override
	public BranchDTO findBypk(long pk) {
		log.info("BranchDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		BranchDTO dto = (BranchDTO) session.get(BranchDTO.class, pk);
		log.info("BranchDAOImpl FindByPk method End");
		return dto;
	}




	@Override
	public void update(BranchDTO dto) {
		log.info("BranchDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("BranchDAOImpl update method End");
	}
	
	
}
