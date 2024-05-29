package com.upt.dao;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upt.dto.CostDTO;
@Repository
public class CostDAOImpl implements CostDAOInt {

	private static Logger log = Logger.getLogger(CostDAOImpl.class.getName());


	@Autowired
	private EntityManager entityManager;
	@Override
	public Long add(CostDTO dto) {
		log.info("CostDAOImpl add method started");
		Session session = entityManager.unwrap(Session.class);
		Long pk = (Long) session.save(dto);
		log.info("CostDAOImpl add method ended");
		return pk;
	}
	@Override
	public Long calculatePrice(Long weight) {
		CostDTO bean = null;
		Long cost1,cost2;
		Long basePrice = 0L;
		Session session = entityManager.unwrap(Session.class);
		Query<CostDTO> query = session.createQuery("FROM CostDTO ORDER BY ID DESC");
		List<CostDTO> list = query.getResultList();
		Iterator<CostDTO> itr = list.iterator();
		if(itr.hasNext()) {
			bean = itr.next();
			cost1 = bean.getCost1();
			cost2 = bean.getCost2();
			if(weight <= 100) {
				basePrice = cost1 * weight;
				System.out.println("bp "+basePrice);
			}else {
				basePrice = cost2 * weight;
				System.out.println("bp2 "+basePrice);
			}
			System.out.println("bean = "+bean.getCost1());
		}
		if(list.size()==0) {
			basePrice = 10L * weight; // set default 10
		}
		System.out.println("size = "+list.size());
		return basePrice;
	}
	@Override
	public CostDTO getCosts() {
		CostDTO bean = null;
		Session session = entityManager.unwrap(Session.class);
		Query<CostDTO> query = session.createQuery("FROM CostDTO ORDER BY ID DESC");
		List<CostDTO> list = query.getResultList();
		Iterator<CostDTO> itr = list.iterator();
		if(itr.hasNext()) {
			bean = itr.next();
		}
		return bean;
	}


}
