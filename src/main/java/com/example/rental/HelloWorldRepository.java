package com.example.rental;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HelloWorldRepository extends JpaRepository<HelloWorld, Long> {

	@Query(value = "SELECT 'Hallå Huiyi!' message", nativeQuery = true)
	HelloWorld getHelloWorldFromDatabase();
}
