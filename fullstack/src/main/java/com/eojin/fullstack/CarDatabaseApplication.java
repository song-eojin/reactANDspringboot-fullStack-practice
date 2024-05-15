package com.eojin.fullstack;

import com.eojin.fullstack.domain.Car;
import com.eojin.fullstack.domain.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarDatabaseApplication implements CommandLineRunner {
// CommandLineRunner : 애플리케이션이 완전히 시작되기 전에 추가 코드를 실행할 수 있어
// 예제 데이터를 준비하기 좋다.

	private static final Logger logger =
			LoggerFactory.getLogger(CarDatabaseApplication.class);

	// 새로운 자동차 객체를 데이터베이스에 저장할 수 있도록 Repository 의존성 주입
	// 주입하면 run 메서드에서 CRUD 메서드 이용이 가능해짐
	@Autowired
	private CarRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CarDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000));
		repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000));
		repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000));

		//모든 자동차를 가져와 콘솔에 로깅
		for(Car car: repository.findAll())
			logger.info(car.getBrand() + " " + car.getModel());
	}
}
