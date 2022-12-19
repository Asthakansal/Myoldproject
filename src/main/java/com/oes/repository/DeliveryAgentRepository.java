package com.oes.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.oes.entity.DeliveryAgent;



@Repository
public interface DeliveryAgentRepository extends JpaRepository<DeliveryAgent, Integer> {

}