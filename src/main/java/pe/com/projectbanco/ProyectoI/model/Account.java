package pe.com.projectbanco.ProyectoI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "account")
@Data

public class Account {
    private Integer idAccount;
    private Integer idCustomer;
    private Integer idProduct;
    private Date dateOpen;
    private double amount;
}
