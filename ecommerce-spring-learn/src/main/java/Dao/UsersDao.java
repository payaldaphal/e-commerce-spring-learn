package Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Users;

public interface UsersDao extends JpaRepository<Users, Integer> {

		public Users findByFirstName(String firstName);

		public Users findByLoginName(String loginName);

	}

