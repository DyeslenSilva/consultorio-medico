package medico.cirurgias.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
@Entity(name = "agendacirurgia")
public class AgendaCirurgias {

	@Id
	private String token;

	@Column
	private String cpf;
	
	@Column
	private String nomePaciente;
	
	@Column
	private String medicoRequerente;
	
	@Column
	private String medicoCirurgiao;
	
	@Column
	private String nomeCirurgia;
	
	@Column
	private String tipoCirurgia;
	
	@Column
	private String riscoCirurgia;
	
	@Column
	private String dataCirurgia;
	
	@Column
	private String horaCirurgia;
}
