package com.ony.Sensores.repository;

import com.ony.Sensores.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    List<Sensor> findByNodo(Integer node);

    @Query(value="SELECT * FROM sensor WHERE ts_fecha_registro  BETWEEN ? AND ?", nativeQuery =true)
    public List<Sensor> findByDate(@Param("startDate") Date startDate, @Param("finalDate")Date finalDate);
}
