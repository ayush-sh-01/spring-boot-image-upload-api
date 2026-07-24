package new_spring_project.second_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import new_spring_project.second_project.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	

}
