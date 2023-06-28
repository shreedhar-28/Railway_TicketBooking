package mvc.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mvc.dto.Student;
import mvc.service.StudentService;

@Controller   								//Take request from DispatcherServlet and allowing for implementation classes to be auto detected through classpath scanning.
public class StudentController {
	
	/*@RequestMapping(name="save", method = RequestMethod.POST) //use to Make web resources addressable or use to map web requests
	public ModelAndView save(@RequestParam String name, @RequestParam long mobile........) //instead of writing all one by one use @ModelAttribute[internally set method will call 
	{ 
		
	}*/
	
	
	/*@PostMapping("save")
	@ResponseBody  //if the return type is String then use @ResponseBody or else gives error like 404
	public String save(@ModelAttribute Student student, @RequestParam String date) { 
		student.setDob(Date.valueOf(date)); 					// write logical part in service package
		return student.toString();
	}*/
	 
	
	@Autowired				//one class of object will initialized in to this class // automatic dependency[object] injection  //Object will be inject by Spring ioc
	StudentService service;
	
	@PostMapping("save")		//@PostMapping is a composed annotation that acts as a shortcut for @RequestMapping  //if we are passing data through form tag then use PostMapping
	public ModelAndView save(@ModelAttribute Student student, @RequestParam String date) {
		return service.save(student, date);
	}
	
	
	@GetMapping("FetchAll")				//If we didn't have form tag or didn't pass any data through form then use GetMapping  
	public ModelAndView fetchAll() {
		return service.fetchAll();
	}
	
	@PostMapping("fetchbyname")
	public ModelAndView fetchByName(@RequestParam String name) {
		return service.fetchByName(name);
	}
	
	@GetMapping("delete")
	public ModelAndView delete(@RequestParam int id) {
		return service.delete(id);
	}
	
	@GetMapping("edit")
		public ModelAndView edit(@RequestParam int id) {
			return service.edit(id);
		}
	@PostMapping("update")
		public ModelAndView update(@ModelAttribute Student student, @RequestParam String date) {
		return service.update(student, date);
	}
	
}
