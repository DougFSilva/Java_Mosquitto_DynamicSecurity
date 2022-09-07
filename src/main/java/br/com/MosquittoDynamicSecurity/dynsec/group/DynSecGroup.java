package br.com.MosquittoDynamicSecurity.dynsec.group;

/**
 * A classe <b>DynSecGroup</b> define um group Mosquitto. Ao group pode ser atribuidos clients e roles 
 * @author Douglas Ferreira da Silva
 * @since Set 2022
 * @version 1.0
 */
public class DynSecGroup {

	private String groupname;

	public DynSecGroup(String groupname) {
		this.groupname = "group_" + groupname;
	}
	
	public String getGroupname() {
		return groupname;
	}

}
