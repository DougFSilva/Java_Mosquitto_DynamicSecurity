package br.com.MosquittoDynamicSecurity.dynsec.group;

import com.google.gson.JsonObject;

import br.com.MosquittoDynamicSecurity.dynsec.DynSecCommandType;
import br.com.MosquittoDynamicSecurity.dynsec.client.DynSecClient;
import br.com.MosquittoDynamicSecurity.dynsec.role.DynSecRole;

/**
 * A classe <b>GroupCommand</b> possui métodos que retornam um JsonObject
 * contendo comandos para configuração de group do Broker Mosquitto. Os objetos
 * JsonObject retornados podem ser inseridos na classe <b>DynSecPublisher</b>
 * pelo método <i>addCommand(JsonObject command)</i> e publicados no tópico de
 * segurança dinâmica do Broker pelo método <i>publish()</i>
 * 
 * @author Douglas Ferreira da Silva
 * @since Set 2022
 * @version 1.0
 */
public class DynSecGroup {

	private String groupname;

	public DynSecGroup() {
	}

	public DynSecGroup(String groupname) {
		this.groupname = groupname;
	}

	/**
	 * @return Retorna um JsonObject contendo o comando para criar um group
	 */
	public JsonObject createCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.CREATE_GROUP.getDescription());
		command.addProperty("groupname", groupname);
		return command;
	}

	/**
	 * @return Retorna um JsonObject contendo o comando para deletar um group
	 */
	public JsonObject deleteCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.DELETE_GROUP.getDescription());
		command.addProperty("groupname", groupname);
		return command;
	}

	/**
	 * @param client Objeto do tipo DynSecClient a ser adicionado ao grupo
	 * @return Retorna um JsonObject contendo o comando para adicionar um client em
	 *         um group
	 */
	public JsonObject addClientCommand(DynSecClient client) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.ADD_GROUP_CLIENT.getDescription());
		command.addProperty("groupname", groupname);
		command.addProperty("username", client.getUsername());
		return command;
	}

	/**
	 * @param client   Objeto do tipo DynSecClient a ser adicionado ao group
	 * @param priority Valor inteiro da prioridade que se deseja configurar
	 * @return Retorna um JsonObject contendo o comando para adicionar um client em
	 *         um group com definição de priodidade<br/>
	 *         Para saber mais sobre prioridade de verificação de segurança dinâmica
	 *         consulte a documentação do Mosquitto
	 * @see <a href=
	 *      "https://mosquitto.org/documentation/dynamic-security/">Mosquitto
	 *      Documentation</a>
	 */
	public JsonObject addClientWithPriorityCommand(DynSecClient client, Integer priority) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.ADD_GROUP_CLIENT.getDescription());
		command.addProperty("groupname", groupname);
		command.addProperty("username", client.getUsername());
		command.addProperty("priority", priority);
		return command;
	}

	/**
	 * @param client Objeto do tipo DynSecClient a ser removido do group
	 * @return Retorna um JsonObject contendo o comando para remover um client de um
	 *         group
	 */
	public JsonObject removeClientCommand(DynSecClient client) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.REMOVE_GROUP_CLIENT.getDescription());
		command.addProperty("groupname", groupname);
		command.addProperty("username", client.getUsername());
		return command;
	}

	/**
	 * @param role Objeto do tipo DynSecRole a ser adicionado ao group
	 * @return Retorna um JsonObject contendo o comando para adicionar uma role a um
	 *         group
	 */
	public JsonObject addRoleCommand(DynSecRole role) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.ADD_GROUP_ROLE.getDescription());
		command.addProperty("groupname", groupname);
		command.addProperty("rolename", role.getRolename());
		return command;
	}

	/**
	 * @param role     Objeto do tipo DynSecRole a ser adicionado ao group
	 * @param priority Valor inteiro da prioridade que se deseja configurar
	 * @return Retorna um JsonObject contendo o comando para adicionar uma role a um
	 *         group com definição de prioridade<br/>
	 *         Para saber mais sobre prioridade de verificação de segurança dinâmica
	 *         consulte a documentação do Mosquitto
	 * @see <a href=
	 *      "https://mosquitto.org/documentation/dynamic-security/">Mosquitto
	 *      Documentation</a>
	 */
	public JsonObject addRoleWithPriorityCommand(DynSecRole role, Integer priority) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.ADD_GROUP_ROLE.getDescription());
		command.addProperty("groupname", groupname);
		command.addProperty("rolename", role.getRolename());
		command.addProperty("priority", priority);
		return command;
	}

	/**
	 * @param role Objeto do tipo DynSecRole a ser removido de um group
	 * @return Retorna um JsonObject contendo o comando para remover uma role de um
	 *         group
	 */
	public JsonObject removeRoleCommand(DynSecRole role) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.REMOVE_GROUP_ROLE.getDescription());
		command.addProperty("groupname", groupname);
		command.addProperty("rolename", role.getRolename());
		return command;
	}

	/**
	 * @return Retorna um JsonObject contendo o comando para buscar o group
	 *         anonymous <br/>
	 *         Para saber mais sobre group anonymous consulte a documentação do
	 *         mosquitto
	 * @see <a href=
	 *      "https://mosquitto.org/documentation/dynamic-security/">Mosquitto
	 *      Documentation</a>
	 */
	public JsonObject getAnonymousCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.GET_ANONYMOUS_GROUP.getDescription());
		return command;
	}

	/**
	 * @return Retorna um JsonObject contendo o comando para setar um group como
	 *         anonymous <br/>
	 *         Para saber mais sobre group anonymous consulte a documentação do
	 *         mosquitto
	 * @see <a href=
	 *      "https://mosquitto.org/documentation/dynamic-security/">Mosquitto
	 *      Documentation</a>
	 */
	public JsonObject setAnonymousCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.SET_ANONYMOUS_GROUP.getDescription());
		command.addProperty("groupname", groupname);
		return command;
	}

	/**
	 * @return Retorna um JsonObject contendo o comando para buscar um group
	 */
	public JsonObject getGroupCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.GET_GROUP.getDescription());
		command.addProperty("groupname", groupname);
		return command;
	}

	/**
	 * @return Retorna um JsonObject contendo o comando para listar os groups
	 */
	public JsonObject listGroupsCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.LIST_GROUP.getDescription());
		return command;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	@Override
	public String toString() {
		return "DynSecGroup [groupname=" + groupname + "]";
	}

}
