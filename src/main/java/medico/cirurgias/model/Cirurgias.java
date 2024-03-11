package medico.cirurgias.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity(name = "cirurgia")
@Table
public class Cirurgias {

	@Id
	private Integer codCirurgia;

	@Column
	private String nomeCirurgia;
	
	@Column
	private String tipoCirurgia;

	@Column
	private String riscoCirurgia;
}
