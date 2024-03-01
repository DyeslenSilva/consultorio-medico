package estado.sistema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "estado")
@Table
@Data
public class Estado {

	@Id
	private String uf;
	
	@Column
	private String nomeEstado;
}
