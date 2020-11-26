package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.BooksLoan;

@Repository
public interface BooksLoanDao extends JpaRepository<BooksLoan, Integer>{
	
	BooksLoan findById(int id);
	BooksLoan findByBookId(int id);
	BooksLoan findByBookIsbn(String isbn);
	List<BooksLoan> findByBookTitle(String title);
	List<BooksLoan> findByBookAuthor(String author);
	List<BooksLoan> findByBookEditor(String editor);
	List<BooksLoan> findByBookRelDate(Date relDate);
	List<BooksLoan> findByReaderId(int id);
	List<BooksLoan> findByReaderName(String name);
	List<BooksLoan> findByReaderEmail(String email);
}
