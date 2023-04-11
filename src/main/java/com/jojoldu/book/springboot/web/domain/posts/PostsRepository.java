package com.jojoldu.book.springboot.web.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 * @ibatis,MyBatis : Dao 라고 불리는 DB Layer 접근자
 * @JPA : Repository, 인터페이스로 생성한다. JpaRepository<Entity, pk time>를 상속하면 기본적인 CRUD 메서드가 자동 생성된다.
 * ※ Entity 클래스와 기본 Entity Repository가 함께 위치해야 한다.
 * @CRUD : 기본적인 데이터 처리 기능인 Create, Read, Update, Delete 를 말함
 * = SQL : INSERT, SELECT, UPDATE, DELETE
 * = Server : POST, GET, PUT, DELETE
 */
@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p From Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
