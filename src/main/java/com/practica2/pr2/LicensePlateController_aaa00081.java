package com.practica2.pr2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/parking")
public class LicensePlateController_aaa00081 {

    @Autowired
    private ParkingRecord_Repository_aaa00081 repository;

    @PostMapping("/registroMatricula_aaa00081")
    public String registerAccess(@RequestBody ParkingRecord_DTO_aaa00081 data) {
        
        // 1. Creamos la entidad que se va a guardar en la base de datos
        ParkingRecord_DTO_aaa00081 record = new ParkingRecord_DTO_aaa00081();
        
        // 2. Pasamos los datos del DTO a la Entidad
        record.setMatricula(data.getMatricula());
        record.setEntrada(data.isEntrada());

        // 3. Guardamos en la base de datos usando tu repositorio
        repository.save(record);
        
        // 4. Devolvemos un mensaje de confirmación
        String action = data.isEntrada() ? "entrada" : "salida";
        return "Registro guardado correctamente: Vehículo " + data.getMatricula() + " en " + action;
    }
}





