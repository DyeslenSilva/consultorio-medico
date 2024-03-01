package medico.consultorio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table
@Entity(name = "medico")
@Data
public class Medico {

	@Id
	private String crm;
	
	@Column
	private String nomeMedico;
	
	
	@Column
	private String especialidade;
	
	@Column
	private Integer ddd;
	
	@Column
	private String telefone;
	
	@Column
	private String email;
	
	@Column
	private String cidade;
	
	@Column
	private String estado;
	
}
