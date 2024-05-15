package com.eojin.fullstack.domain;

import com.eojin.fullstack.domain.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    //모델로 자동차 검색
    List<Car> findByModel(String model);

    //색상으로 자동차 검색
    List<Car> findByColor(String color);

    //And 및 Or 키워드 붙여 여러 필드 지정
    List<Car> findByYearAndBrand(int year, String brand);
    List<Car> findByBrandOrModel(String brand, String model);

    //브랜드로 자동차를 검색하고 연도로 정렬
    List<Car> findByBrandOrderByYearAsc(String brand);

    //@Query 어노테이션을 이용한 SQL 문으로 쿼리 만들기
    @Query("select c from Car c where c.brand = ?1")
    List<Car> findByBrand(String brand);

    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrandEndsWith(String brand);
}
