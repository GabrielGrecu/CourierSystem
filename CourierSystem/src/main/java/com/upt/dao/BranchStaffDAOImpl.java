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

import com.upt.dto.BranchStaffDTO;


@Repository
public class BranchStaffDAOImpl implements BranchStaffDAOInt{

	private static Logger log = Logger.getLogger(BranchStaffDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(BranchStaffDTO dto) {
		log.info("BranchSatffDAOImpl start method started");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long)session.save(dto);
		log.info("BranchSatffDAOImpl Add method ends");
		return pk;
	}




	@Override
	public List<BranchStaffDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<BranchStaffDTO> list(int pageNo, int pageSize) {
		log.info("BranchSatffDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<BranchStaffDTO> query = session.createQuery("from BranchStaffDTO", BranchStaffDTO.class);
		List<BranchStaffDTO> list = query.getResultList();
		log.info("BranchSatffDAOImpl List method End");
		return list;
	}

	@Override
	public List<BranchStaffDTO> search(BranchStaffDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<BranchStaffDTO> search(BranchStaffDTO dto, int pageNo, int pageSize) {
		log.info("BranchSatffDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(BranchStaffDTO.class);
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
		log.info("BranchSatffDAOImpl Search method End");
		return criteria.list();
	}
	
	@Override
	@Transactional
	public void delete(BranchStaffDTO dto) {
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));

	}




	@Override
	public BranchStaffDTO findBypk(long pk) {
		log.info("BranchSatffDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		BranchStaffDTO dto = (BranchStaffDTO) session.get(BranchStaffDTO.class, pk);
		log.info("BranchSatffDAOImpl FindByPk method End");
		return dto;
	}




	@Override
	public void update(BranchStaffDTO dto) {
		log.info("BranchSatffDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("BranchSatffDAOImpl update method End");
	}




	@Override
	public BranchStaffDTO findByUserId(long userId) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(BranchStaffDTO.class);
		criteria.add(Restrictions.eq("userId", userId));
		BranchStaffDTO dto = (BranchStaffDTO) criteria.uniqueResult();
		return dto;
	}
	
	
}
