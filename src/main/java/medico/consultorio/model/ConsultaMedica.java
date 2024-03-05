package medico.consultorio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Table
@Entity(name = "consulta")
@Data
public class ConsultaMedica {
	
	@Id
	private String token;
	
	@Column
	private String cpf;
	
	@Column
	private String nomeDoPaciente;
	
	@Column
	private String nomeMedico;
	
	@Column
	private String especialidade;
	
	@Column
	private String dataDaConsulta;
	
	@Column
	private String horaDaConsulta;
	
	@Column
	private String endereco;
	
	@Column
	private Integer n;
	
	@Column
	private String cidade;
	
	@Column
	private String estado;
}
