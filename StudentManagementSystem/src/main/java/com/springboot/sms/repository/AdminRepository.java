package com.springboot.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.sms.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {

}
