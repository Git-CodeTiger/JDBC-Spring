package studio.codeocean.ctrls;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import studio.codeocean.services.StudentService;
import studio.codeocean.common.Result;
import studio.codeocean.models.domain.Student;
import java.util.List;

@RestController
@RequestMapping("/why")
public class Operation {
	
	@RequestMapping("/smile")
	public String index() {
		return "Why is not resolution?";
	}

	private StudentService studentService = new StudentService();


	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public Result insert(@ModelAttribute Student student) {
		 Result result = new Result();
		if(student.getName() == null || student.getSex() == null || student.getAge() == 0 || student.getSchool() == null || student.getMajor() == null || student.getClazz() == null ) {
			result.setStatus(0, "操作失败");
			System.out.println(result.getStatus() );
			return result;
		}
		return studentService.insert(student);
	}

	@RequestMapping(value="/selects", method=RequestMethod.GET)
	public List<Student> selects() {
		return studentService.selects();
	}

	@RequestMapping(value="/select", method=RequestMethod.POST)
	public Result select(String name) {
		Result result = new Result();
		if(name.equals(" ") == true) {
			result.setStatus(0, "操作失败");
			return result;
		}
		return studentService.select(name);
	}

	@RequestMapping(value="/update", method=RequestMethod.POST)
	public Result update(@ModelAttribute Student student) {
		Result result = new Result();
		if((int)select(student.getName()).getStatus().get("code") == 0) {
			result.setStatus(0, "操作失败");
			return result;
		}
		return studentService.update(student);
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public Result delete( String name) {
		Result result = new Result();
		if((int)select(name).getStatus().get("code") == 0){
			result.setStatus(0, "操作失败");
			return result;
		}
		return studentService.delete(name);	
	}

}
