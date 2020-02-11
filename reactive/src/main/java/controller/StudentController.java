package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import entity.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import service.StudentService;


@RestController
public class StudentController {
	
	@Autowired
    private StudentService studentService;

    @PostMapping( value="/student" ,consumes="application/json")
    public void registerStudent(@RequestBody Student student) {
    	System.out.println("Recieved Request: " +student);
    	studentService.saveStudent(student);   	
		return ;
    }
	
    @GetMapping(value = "/students", produces = "application/json")
    public Flux<Student> listStudents(){    	
        return studentService.listAll();
    }

    @GetMapping(value = "/students/{id}", produces = "application/json")
    public Mono<Student> getStudent(@PathVariable String id){
        return studentService.getById(Long.valueOf(id));
    }
    

    @DeleteMapping(value = "/students/{id}", produces = "application/json")
    public void deleteAStudent(@PathVariable String id){
		studentService.delete(Long.valueOf(id));
        return ;
    }


}
