package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entitiy.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.UserRequest;
import com.example.demo.request.UserUpdateRequest;

/**
 * Person情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
	/**
	 * ユーザー情報 Repository
	 */
	@Autowired
	private UserRepository userRepository;

	public List<UserEntity> searchAll() {
		// ユーザー全検索
		return userRepository.findAll();
	}

	// ユーザ-主キー検索
	public UserEntity findById(Long id) {
		return userRepository.findById(id).get();
	}

	// ユーザ-登録
	public void create(UserRequest userRequest) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(userRequest.getName());
		userEntity.setUpn(userRequest.getUpn());
		userEntity.setPassword(userRequest.getPassword());
		userRepository.save(userEntity);
	}

	// ユーザー編集
	public void update(UserUpdateRequest userUpdateRequest) {
		UserEntity userEntity = findById(userUpdateRequest.getId());
		userEntity.setName(userUpdateRequest.getName());
		userEntity.setUpn(userUpdateRequest.getUpn());
		userEntity.setPassword(userUpdateRequest.getPassword());
		userRepository.save(userEntity);
	}

	// ユーザー削除
	public void delete(Long id) {
		UserEntity userEntity = findById(id);
		userRepository.delete(userEntity);
	}

}
//