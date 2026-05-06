package com.practica2.pr2;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "parking")
public class ParkingRecord_DTO_aaa00081 {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licensePlate;
    
    private boolean entry; 
    
    @CreationTimestamp(source = SourceType.DB)
    private LocalDateTime timestamp;

    public ParkingRecord_DTO_aaa00081() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public boolean isEntry() { return entry; }
    public void setEntry(boolean entry) { this.entry = entry; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

}
