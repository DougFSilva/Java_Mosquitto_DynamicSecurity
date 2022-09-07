package br.com.MosquittoDynamicSecurity.dynsec.role;

/**
 * A classe <b>DynSecRole</b> define uma Role Mosquitto. As roles são atribuidas a um client ou group. 
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
	
	/**
	 * Construtor que adiciona uma "baseName" seguido de um underline definida pelo usuário antes da rolename
	 * @param rolename - nome da role a ser criada.
	 * @param baseName - String seguido de um underline a ser adicionado antes do rolename
	 */
	public DynSecRole(String rolename, String baseName) {
		this.rolename = baseName + "_" + rolename;
	}

	public String getRolename() {
		return rolename;
	}

}
