package localizacao.teste;

import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

public class TesteLocalizacao {

	public static void main(String[] args) throws UnirestException {
		String cep = "06655000";
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        
        JsonNode response = Unirest.get(url).asJson().getBody();
        
        if(response.getObject().has("erro")) {
        	System.out.println("CEP não encontrado");
        }else {
        	String logradouro = response.getObject().getString("logradouro");
        	String bairro = response.getObject().getString("bairro");
        	String cidade = response.getObject().getString("localidade");
        	String estado = response.getObject().getString("uf");
        	
        	System.out.println("Logradouro: "+logradouro);
        	System.out.println("Bairro: "+bairro);
        	System.out.println("Cidade: "+cidade);
        	System.out.println("Estado: "+estado);
        }
	}
}
