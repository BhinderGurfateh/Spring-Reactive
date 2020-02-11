package dao;


import org.springframework.data.repository.query.Param;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import entity.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ReactiveCrudRepositoryCustom extends ReactiveCrudRepository<Student, Long> {
	
    @Query(value="Select * from student ") 
    Flux<Student> findAllStudents();

//    @Query(value="Select * from student where id =:SID") 
//	Mono<Student> findByStudentId(@Param("SID") Long id);


}
