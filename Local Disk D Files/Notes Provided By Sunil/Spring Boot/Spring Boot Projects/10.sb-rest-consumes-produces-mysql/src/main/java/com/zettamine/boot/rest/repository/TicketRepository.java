package com.zettamine.boot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.boot.rest.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, String> {

}
