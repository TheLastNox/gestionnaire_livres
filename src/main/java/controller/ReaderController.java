package controller;

import model.Reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.ReaderDao;

@Controller
@RequestMapping(path="/")
public class ReaderController {
	@Autowired
	private ReaderDao readerDao;
	
	@GetMapping(path="/reader/all")
	public @ResponseBody Iterable<Reader> getAllReaders() {
		return readerDao.findAll();
	}
	
	@GetMapping(value = "/reader/id/{id}")
	public Reader getReaderById(@PathVariable int id) {
		return readerDao.findById(id);
	}
	
	@GetMapping(value = "/reader/name/{name}")
	public Iterable<Reader> getReadersByName(@PathVariable String name) {
		return readerDao.findByName(name);
	}
	
	@GetMapping(value = "/reader/email/{email}")
	public Iterable<Reader> getReadersByEmail(@PathVariable String email) {
		return readerDao.findByEmail(email);
	}
	
	@PostMapping(path="/reader/add")
	public @ResponseBody String addNewReader (@RequestBody Reader reader) {
		readerDao.save(reader);
		return "Ajouté!";
	}
	
	@PutMapping (value = "/reader/update")
	public String updateReader(@RequestBody Reader reader) {
		readerDao.save(reader);
		return "Mis à jour!";
	}
	
	@DeleteMapping (value = "/reader/{id}")
	public String deleteReaderById(@PathVariable int id) {
		readerDao.deleteById(id);
		return "Supprimé!";
	}
}
