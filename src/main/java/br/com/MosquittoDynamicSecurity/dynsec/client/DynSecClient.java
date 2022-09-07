package br.com.MosquittoDynamicSecurity.dynsec.client;

/**
 * A classe <b>DynSecClient</b> define um client Mosquitto. O client pode ou não conter o atributo Id. Quando o client possui um 
 * id específico não será possível mais de uma conexão simultânea com o Broker Mosquito. 
 * @author Douglas Ferreira da Silva
 * @since Set 2022
 * @version 1.0
 */
public class DynSecClient {
	
	private String id;
	
	private String username;

	private String password;
	

	public DynSecClient(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public DynSecClient(String username, String password, String id) {
		this.username = username;
		this.password = password;
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getId() {
		return id;
	}

}
