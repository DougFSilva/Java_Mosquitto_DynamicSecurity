package br.com.MosquittoDynamicSecurity.dynsec.role.ACL;

/**
 * A classe <b>DynSecACL</b> define um ACL que pode ser atribuido a uma Role.
 * 
 * @author Douglas Ferreira da Silva
 * @since Set 2022
 * @version 1.0
 * @see <a href=
 *      "https://mosquitto.org/documentation/dynamic-security/">Mosquitto
 *      Dcoumentation</a>
 */
public class DynSecACL {

	private ACLType aclType;

	private String topic;

	private boolean allow;

	/**
	 * @param aclType  - Tipos de ACL possíveis de serem atribuidos aos tópicos
	 *                 criados
	 * @param topic    - Tópico no qual se deseja permitir as operações definidas
	 *                 pela aclType
	 * @param allow    - Booleano para permitir ou não a operação aclType no tópico
	 *                 em questão
	 * @param priority - prioridade de verificação da segurança dinâmica
	 */
	public DynSecACL(ACLType aclType, String topic, boolean allow) {
		this.aclType = aclType;
		this.topic = topic;
		this.allow = allow;
	}

	public ACLType getAclType() {
		return aclType;
	}

	public String getTopic() {
		return topic;
	}

	public boolean isAllow() {
		return allow;
	}

}
