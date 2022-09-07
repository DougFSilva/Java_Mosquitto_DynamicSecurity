package br.com.MosquittoDynamicSecurity.dynsec.ACL;

/**
 * O Enum <b>ACLType</b> define os tipos de ACLs possíveis de serem atribuídos à classe <b>DynSecACL</b>. Essas são as operações 
 * possíveis de serem permitidas ou não permitidas aos tópicos criados no Mosquitto.
 * @author Douglas Ferreira da Silva
 * @since Set 2022
 * @version 1.0
 * @see <a href="https://mosquitto.org/documentation/dynamic-security/">Mosquitto Documentation</a>
 */
public enum ACLType {

	PUBLISH_CLIENT_SEND("publishClientSend"),
	PUBLISH_CLIENT_RECEIVE("publishClientReceive"),
	SUBSCRIBE_LITERAL("subscribeLiteral"),
	SUBSCRIBE_PATTERN("subscribePattern"),
	UNSUBSCRIBE_LITERAL("unsubscribeLiteral"),
	UNSUBSCRIBE_PATTERN("unsubscribePattern");
	
	private String description;

	private ACLType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}
