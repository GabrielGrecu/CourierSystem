package com.upt.service;

import java.util.List;

import com.upt.dto.UserDTO;
import com.upt.exception.DuplicateRecordException;

public interface UserServiceInt {

	long add(UserDTO dto) throws DuplicateRecordException;

	void delete(UserDTO dto);

	UserDTO findBypk(long pk);

	UserDTO findByLogin(String login);

	void update(UserDTO dto) throws DuplicateRecordException;

	List<UserDTO> list();

	List<UserDTO> list(int pageNo, int pageSize);

	List<UserDTO> search(UserDTO dto);

	List<UserDTO> search(UserDTO dto, int pageNo, int pageSize);

	UserDTO authentication(UserDTO dto);
	
	boolean changePassword(Long id, String oldPassword, String newPassword);
	  
	boolean forgetPassword(String login);
	
	Long countUser();
}
