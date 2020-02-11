package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReactiveCrudRepositoryCustom;
import entity.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {
    
	@Autowired
    private ReactiveCrudRepositoryCustom studentRepository;


    @Override
    public Flux<Student> listAll() {
        return studentRepository.findAllStudents(); 
    }

    @Override
    public Mono<Student> getById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void saveStudent(Student student) {
    	System.out.println("Db called::"+student);
    	Mono<Student> s=studentRepository.save(student);
    	System.out.println("Db retured::"+s.toString());
        return ;
    }

    @Override
    public void delete(Long id) {
    	studentRepository.deleteById(id);

    }


}
