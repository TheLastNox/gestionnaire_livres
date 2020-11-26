package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.BooksLoan;

@Repository
public interface BooksLoanDao extends JpaRepository<BooksLoan, Integer>{
	
	BooksLoan findById(int id);
}
