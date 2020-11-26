package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
	
	Book findById(int id);
	List<Book> findByTitle(String title);
	List<Book> findByAuthor(String author);
	List<Book> findByEditor(String editor);
	List<Book> findByRelDate(Date relDate);
	List<Book> findByAvailable(boolean available);
}
