package service;

import java.util.List;

import entity.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface StudentService {

    Flux<Student> listAll();

    Mono<Student> getById(Long id);

    void delete(Long id);

    void saveStudent(Student student);
}
