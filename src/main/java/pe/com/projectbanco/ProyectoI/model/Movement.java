package pe.com.projectbanco.ProyectoI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "movement")

public class Movement {
    @Id
    private String id;
    @Valid
    private Customer customer;
    private double availableBalance;
    private Integer limiteMovimiento;
    private double amount;
    private String dateOpen;


}

