package com.ony.Sensores.controller;

import com.ony.Sensores.entity.Sensor;
import com.ony.Sensores.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sensor")
public class SensorController {
    @Autowired
    SensorService sensorService;

    @GetMapping
    public ResponseEntity<List<Sensor>> getAll(){
        List<Sensor> sensors = sensorService.getAll();
        if (sensors.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(sensors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sensor> getById(@PathVariable("id") int id){
        Sensor sensor= sensorService.getUserById(id);
        if (sensor == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sensor);
    }

    @GetMapping("/node/{node}")
    public ResponseEntity<List<Sensor>> getByNodeId(@PathVariable("node") int node){
        List<Sensor> sensors = sensorService.getByNodeId(node);
        if (sensors.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sensors);
    }

    @GetMapping("/date")
    public ResponseEntity<List<Sensor>> getByDateTimeBetween(
            @RequestParam(value="startDate",required=false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(value="finalDate",required=false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date finalDate) throws ParseException {
        List<Sensor> sensors = sensorService.getByDateTimeBetween(startDate,finalDate);
        if (sensors.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sensors);
    }

    @PostMapping
    public ResponseEntity<Sensor> save(@RequestBody Sensor sensor){
        Sensor sensorNew= sensorService.save(sensor);
        return ResponseEntity.ok(sensorNew);
    }
}
