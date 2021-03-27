package com.example.test.domin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface bookRepository extends JpaRepository<Book , Long> {

    List<Book> findByAuthor(String author);
//    JPQL語法
//    @Query("SELECT b from Book b where b.price >?1")
    @Query(value = "SELECT * from book where price >?1" ,nativeQuery = true)
    List<Book> findByPrice(int price);

    @Transactional
    @Modifying
    @Query("UPDATE Book b SET b.price = ?1  where b.id = ?2")
    int updateByPrice( int price , long id);


}
