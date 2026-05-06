package com.practica2.pr2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.time.Duration;

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


    @GetMapping("/ticket_aaa00081/{matricula}")
    public String generarTicket(@PathVariable String matricula) {

        // 1. Buscamos el último registro de ENTRADA (entrada = true)
        ParkingRecord_DTO_aaa00081 registroEntrada = repository.findTopByMatriculaAndEntradaOrderByHoraDesc(matricula, true);
        
        // 2. Buscamos el último registro de SALIDA (entrada = false)
        ParkingRecord_DTO_aaa00081 registroSalida = repository.findTopByMatriculaAndEntradaOrderByHoraDesc(matricula, false);

        // 3. Validaciones
        if (registroEntrada == null || registroSalida == null) {
            return "Error: No hay registros completos para la matricula " + matricula;
        }

        // Comprobar que la salida es después de la entrada
        if (registroSalida.getHora().isBefore(registroEntrada.getHora())) {
            return "Error: El vehiculo con matricula " + matricula + " todavia esta dentro.";
        }

        // 4. Calculo de tiempo y coste
        Duration duracion = Duration.between(registroEntrada.getHora(), registroSalida.getHora());
        long minutos = duracion.toMinutes();
        
        // Ponemos un precio de ejemplo: 0.02€ por minuto
        double coste = minutos * 0.02;

        // 5. Respuesta formateada
        return "--- TICKET DE APARCAMIENTO ---\n" +
               "Matricula: " + matricula + "\n" +
               "Entrada: " + registroEntrada.getHora() + "\n" +
               "Salida: " + registroSalida.getHora() + "\n" +
               "Tiempo total: " + minutos + " minutos\n" +
               "Importe a pagar: " + String.format("%.2f", coste) + " euros";
    }
}





