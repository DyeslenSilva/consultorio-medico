package medico.consultorio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity(name = "paciente")
@Table
public class Paciente {
	
	@Id
	private String cpf;
	
	@Column
	private String nomePaciente;

	@Column
	private String telefone;
	
	@Column
	private String endereco;
	
	@Column
	private Integer nCasa;
	
	@Column
	private String cidade;
	
	@Column
	private String estado;
	
	

}
