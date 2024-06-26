package com.upt.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upt.dto.BranchDTO;
import com.upt.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAOInt {

	private static Logger log = Logger.getLogger(UserDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(UserDTO dto) {
		log.info("UserDAOImpl start method started");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long)session.save(dto);
		log.info("UserDAOImpl Add method ends");
		return pk;
	}

	@Override
	public void delete(UserDTO dto) {
		Session session = entityManager.unwrap(Session.class);
		Query<BranchDTO> query = session.createSQLQuery("delete from c_user where id = "+dto.getId()+"");
		query.executeUpdate();

	}

	@Override
	public UserDTO findBypk(long pk) {
		log.info("UserDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		UserDTO dto = (UserDTO) session.get(UserDTO.class, pk);
		log.info("UserDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public UserDTO findByLogin(String login) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("login", login));
		UserDTO dto = (UserDTO) criteria.uniqueResult();
		return dto;
	}

	@Override
	public void update(UserDTO dto) {
		log.info("UserDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("UserDAOImpl update method End");
	}

	@Override
	public List<UserDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<UserDTO> list(int pageNo, int pageSize) {
		log.info("UserDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<UserDTO> query = session.createQuery("from UserDTO", UserDTO.class);
		List<UserDTO> list = query.getResultList();
		log.info("UserDAOImpl List method End");
		return list;
	}

	@Override
	public List<UserDTO> search(UserDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		log.info("UserDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(UserDTO.class);
		
		//criteria.add(Restrictions.eq("roleId", DataUtility.getLong("2")));
		if (dto != null) {
			dto.setRoleId(3L);
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));
			}
			if (dto.getLogin() != null && dto.getLogin().length() > 0) {
				criteria.add(Restrictions.like("login", dto.getLogin() + "%"));
			}
			if (dto.getRoleId() > 0) {
				criteria.add(Restrictions.eq("roleId", dto.getRoleId()));
			}
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("UserDAOImpl Search method End");
		return criteria.list();
	}

	@Override
	public UserDTO authentication(UserDTO dto) {
		log.info("UserDAOImpl Authentication method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<UserDTO> query = session
				.createQuery("from UserDTO where login=:login and password=:password", UserDTO.class);
		query.setParameter("login",dto.getLogin());
		query.setParameter("password",dto.getPassword());
		dto = null;
		try {
			dto = query.getSingleResult();
		} catch (NoResultException nre) {
			
		}
		log.info("UserDAOImpl Authentication method End");
		return dto;
	}

	@Override
	public Long countUser() {
		Session session = entityManager.unwrap(Session.class);
		Long firstResult = session
			    .createQuery("select count(id) from UserDTO", Long.class)
			    .getSingleResult();
		return firstResult;
	}
	
}
