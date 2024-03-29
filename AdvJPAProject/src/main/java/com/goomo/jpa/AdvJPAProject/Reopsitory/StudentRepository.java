package com.goomo.jpa.AdvJPAProject.Reopsitory;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.goomo.jpa.AdvJPAProject.Entity.Passport;
import com.goomo.jpa.AdvJPAProject.Entity.Student;

@Repository
@Transactional
public class StudentRepository {
	private Logger logger = LoggerFactory.getLogger(Student.class);

	@Autowired
	EntityManager entityManager;
	// find by id
	// save student
	// delete by id

	public Student findById(Long id) {
		return entityManager.find(Student.class, id);
	}

	public Student save(Student student) {
		if (student.getId() == null) {
			// insert data
			entityManager.persist(student);
		} else {
			// update
			entityManager.merge(student);
		}
		return student;
	}

	public void deleteById(Long id) {
		Student student = entityManager.find(Student.class, id);
		entityManager.remove(student);
	}

	public void saveStudentWithPassport() {
		Passport passport = new Passport("E1234");
		entityManager.persist(passport);
		Student student = new Student("Mike");
		student.setPassport(passport);
		entityManager.persist(student);

	}

}
