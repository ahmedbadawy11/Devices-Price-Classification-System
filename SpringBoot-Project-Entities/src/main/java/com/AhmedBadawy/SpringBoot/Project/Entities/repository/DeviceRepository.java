package com.AhmedBadawy.SpringBoot.Project.Entities.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.AhmedBadawy.SpringBoot.Project.Entities.models.Device;


@Repository
public interface DeviceRepository extends MongoRepository <Device,String>{

}
