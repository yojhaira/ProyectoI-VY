package pe.com.projectbanco.ProyectoI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "business")
@Data

public class Business {
    @Id
    private Integer idBusiness;
    private String ruc;
    private String companyName;
    private String legalRepresentative;
    private Integer nroLegalRepresentative;
    private Customer customer;
}
