package com.upt.dao;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upt.dto.CourierDTO;

@Repository
public class CourierDAOImpl implements CourierDAOInt {

	private static Logger log = Logger.getLogger(CourierDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(CourierDTO dto) {
		log.info("CourierDAOImpl start method started");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long)session.save(dto);
		log.info("CourierDAOImpl Add method ends");
		return pk;
	}

	@Override
	public void delete(CourierDTO dto) {
	entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));

	}

	@Override
	public CourierDTO findBypk(long pk) {
		log.info("CourierDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		CourierDTO dto = (CourierDTO) session.get(CourierDTO.class, pk);
		log.info("CourierDAOImpl FindByPk method End");
		return dto;
	}


	@Override
	public void update(CourierDTO dto) {
		log.info("CourierDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<CourierDTO> query = session.createQuery("UPDATE CourierDTO SET status = :status, staff = :staff, staffId = :staffId where id="+dto.getId()+"");
		query.setParameter("status", dto.getStatus());
		query.setParameter("staff", dto.getStaff());
		query.setParameter("staffId", dto.getStaffId());
		query.executeUpdate();
		log.info("CourierDAOImpl update method End");
	}

	@Override
	public List<CourierDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<CourierDTO> list(int pageNo, int pageSize) {
		log.info("CourierDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<CourierDTO> query = session.createQuery("from CourierDTO", CourierDTO.class);
		List<CourierDTO> list = query.getResultList();
		log.info("CourierDAOImpl List method End");
		return list;
	}

	@Override
	public List<CourierDTO> search(CourierDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<CourierDTO> search(CourierDTO dto, int pageNo, int pageSize) {
		log.info("CourierDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(CourierDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getTrackingNo()!=null) {
				criteria.add(Restrictions.like("trackingNo",dto.getTrackingNo()));
			}
			if (dto.getStatus() != null && dto.getStatus().length() > 0) {
				criteria.add(Restrictions.like("status", dto.getStatus() + "%"));
			}
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("CourierDAOImpl Search method End");
		return criteria.list();
	}

	@Override
	public Long generateTrackingNumber() {
		Long trackingNo = null;
		CourierDTO bean = null;
		Session session = entityManager.unwrap(Session.class);
	//	String sql = "SELECT tracking_number FROM c_courier ORDER BY created_datetime DESC, id DESC LIMIT 1";
		String sql = "SELECT trackingNo from CourierDTO order by createdDatetime desc, id desc";
		
		Query createQuery = session.createQuery(sql);
		createQuery.setMaxResults(1);
		List resultList = createQuery.getResultList();
		Iterator itr = resultList.iterator();
		while(itr.hasNext()) {
			trackingNo = (Long)itr.next();
			bean = new CourierDTO();
			System.out.println("tttt >> "+trackingNo);
			bean.setTrackingNo(trackingNo);
		}
		trackingNo = (bean==null) ? 10000: ((bean.getTrackingNo())+1);
		System.out.println("Track >> "+trackingNo);
		return (Long) trackingNo;
	}

	
}
