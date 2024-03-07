package especialidade.sistema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table
@Entity(name="especialidade")
@Data
public class Especialidades {

	@Id
	private String siglaEspecialidade;
	
	@Column
	private String nomeEspecialidade;
	
}
