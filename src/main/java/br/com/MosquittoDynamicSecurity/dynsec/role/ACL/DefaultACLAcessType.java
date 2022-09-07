package br.com.MosquittoDynamicSecurity.dynsec.role.ACL;

/**
 * O Enum <b>DefaultACLAcessType</b> define os tipos de ACLs possíveis de serem atribuídos à configuração default de ACLAcess do
 * Mosquitto
 * @author Douglas Ferreira da Silva
 * @since Set 2022
 * @version 1.0
 * @see <a href="https://mosquitto.org/documentation/dynamic-security/">Mosquitto Dcoumentation</a>
 */
public enum DefaultACLAcessType {

	PUBLISH_CLIENT_SEND("publishClientSend"),
	PUBLISH_CLIENT_RECEIVE("publishClientReceive"),
	SUBSCRIBE("subscribe"),
	UNSUBSCRIBE("unsubscribe");
	
	private String description;

	private DefaultACLAcessType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
