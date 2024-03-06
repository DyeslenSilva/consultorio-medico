package medico.consultorio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "agendaExames")
@Entity
public class MarcaExame  {

	@Id
	private String tokenExame;
	
	@Column
	private String cpf;
	
	@Column
	private String nomePaciente;
	
	@Column
	private String nomeDoExame;
	
	@Column
	private String medicoSolicitante;
	
	@Column
	private String descricaoExame;
	
	@Column
	private String dataExame;
	
	@Column
	private String horaExame;
	
	
}
