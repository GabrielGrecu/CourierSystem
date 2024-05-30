package com.upt.dao;

import java.util.List;

import com.upt.dto.UserDTO;

public interface UserDAOInt {

	long add(UserDTO dto);

	Long countUser();

	void delete(UserDTO dto);

	UserDTO findBypk(long pk);

	UserDTO findByLogin(String login);

	void update(UserDTO dto);

	List<UserDTO> list();

	List<UserDTO> list(int pageNo, int pageSize);

	List<UserDTO> search(UserDTO dto);

	List<UserDTO> search(UserDTO dto, int pageNo, int pageSize);

	UserDTO authentication(UserDTO dto);
}
