package com.ony.Sensores.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int i_id_registro;

    @Column(name = "i_n_nodo" )
    private int nodo;
    private int i_sensor_humedad_suelo1;
    private int i_sensor_humedad_suelo2;
    private int i_sensor_humedad;
    private int i_sensor_temperatura1;
    private int i_sensor_temperatura2;

    @Column(name = "ts_fecha_registro" )
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

}
