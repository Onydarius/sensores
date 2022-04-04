package com.ony.Sensores.service;

import com.ony.Sensores.entity.Sensor;
import com.ony.Sensores.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SensorService {
    @Autowired
    SensorRepository sensorRepository;

    public List<Sensor> getAll(){
        return  sensorRepository.findAll();
    }

    public Sensor getUserById(int id){
        return sensorRepository.findById(id).orElse(null);
    }

    public List<Sensor> getByNodeId(int node){
        return  sensorRepository.findByNodo(node);
    }

    public List<Sensor> getByDateTimeBetween(Date startDate, Date finalDate){
        return  sensorRepository.findByDate(startDate, finalDate);
    }

    public Sensor save(Sensor sensor){
        Sensor sensorNew = sensorRepository.save(sensor);
        return sensorNew;
    }
}
