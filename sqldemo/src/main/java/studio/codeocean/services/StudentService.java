package studio.codeocean.services;

import studio.codeocean.models.dao.StudentDao;
import org.springframework.stereotype.Service;
import studio.codeocean.models.domain.Student;
import studio.codeocean.common.Result;
import java.util.List;

@Service
public class StudentService {
	//@Autowired   import org.springframework.beans.factory.annotation.Autowired;
	private StudentDao studentDao;

	public StudentService() {
		studentDao = new StudentDao();
	}

	public Result insert(Student student) {
		return studentDao.insert(student);
	}

	public List<Student> selects() {
		return studentDao.selects();
	}
	
	public Result select(String name) {
		return studentDao.select(name);
	}

	public Result update(Student student) {
		return studentDao.update(student);
	}

	public Result delete(String name) {
		return studentDao.delete(name);
	}
}
