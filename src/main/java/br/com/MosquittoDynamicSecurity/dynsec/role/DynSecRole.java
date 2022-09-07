package br.com.MosquittoDynamicSecurity.dynsec.role;

/**
 * A classe <b>DynSecRole</b> define uma role Mosquitto. As roles são atribuidas a um client ou group. 
 * @author Douglas Ferreira da Silva
 * @since Set 2022
 * @version 1.0
 * @see <a href="https://mosquitto.org/documentation/dynamic-security/">Mosquitto Dcoumentation</a>
 */
public class DynSecRole {

	private String rolename;

	/**
	 * Construtor que adiciona a String "role_" antes do rolename.
	 * @param rolename - nome da role a ser criada.
	 */
	public DynSecRole(String rolename) {
		this.rolename = "role_" + rolename;
	}
	
	public String getRolename() {
		return rolename;
	}

}
