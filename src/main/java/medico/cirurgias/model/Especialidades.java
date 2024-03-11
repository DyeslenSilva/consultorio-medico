package medico.cirurgias.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity(name = "especialidades")
@Table
public class Especialidades {
	
	@Id
	private int idEspecialidade;

	@Column
	private String nomeEspecialidade;
	
}
