package medico.consultorio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table
@Entity(name = "exame")
@Data
public class Exame {

	@Id
	private Integer codigoDoExame;
	
	@Column
	private String nomeDoExame;
	
	
	@Column
	private String descricao;
	
}
