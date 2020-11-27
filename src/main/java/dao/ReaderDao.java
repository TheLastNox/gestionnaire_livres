package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Reader;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface ReaderDao extends JpaRepository<Reader, Integer> {
	
	Reader findById(int id);
	Reader findByMemberId(String memberId);
	List<Reader> findByName(String name);
	List<Reader> findByEmail(String email);
}