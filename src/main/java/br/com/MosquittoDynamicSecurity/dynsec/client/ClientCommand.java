package br.com.MosquittoDynamicSecurity.dynsec.client;

import com.google.gson.JsonObject;

import br.com.MosquittoDynamicSecurity.dynsec.DynSecCommandType;
import br.com.MosquittoDynamicSecurity.dynsec.role.DynSecRole;

/**
 * A classe <b>ClientCommand</b> possui métodos que retornam um JsonObject contendo comandos para configuração de client
 * do Broker Mosquitto. Os objetos JsonObject retornados podem ser inseridos na classe <b>DynSecPublisher</b> pelo método 
 * <i>addCommand(JsonObject command)</i> e publicados no tópico de segurança dinâmica do Broker pelo método <i>publish()</i>
 * @author Douglas Ferreira da Silva
 * @since Set 2022
 * @version 1.0
 */
public class ClientCommand {

	private DynSecClient client;

	public ClientCommand() {
	}

	public ClientCommand(DynSecClient client) {
		this.client = client;
	}

	/**
	 * @return Retorna um JsonObject contendo o comando para criar um client
	 */
	public JsonObject createCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.CREATE_CLIENT.getDescription());
		command.addProperty("username", client.getUsername());
		command.addProperty("password", client.getPassword());
		return command;
	}
	
	/**
	 * @return Retorna um JsonObject contendo o comando para criar um client com id <br/>
	 * Obs.: Se o client possui um Id ele não pode se conectar ao broker em mais de um dispositivo ao mesmo tempo
	 */
	public JsonObject createWithIdCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.CREATE_CLIENT.getDescription());
		command.addProperty("username", client.getUsername());
		command.addProperty("password", client.getPassword());
		command.addProperty("clientId", client.getId());
		return command;
	}

	/**
	 * @param role Objeto do tipo DynSecRole a ser adicionado ao client
	 * @return Retorna um JsonObject contendo o comando para adicionar uma role a um client
	 */
	public JsonObject addRoleCommand(DynSecRole role) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.ADD_CLIENT_ROLE.getDescription());
		command.addProperty("username", client.getUsername());
		command.addProperty("rolename", role.getRolename());
		return command;
	}

	/**
	 * @param role Objeto do tipo DynSecRole a ser adicionado ao client
	 * @param priority Valor inteiro da prioridade que se deseja configurar 
	 * @return Retorna um JsonObject contendo o comando para adicionar uma role a um client com definição de prioridade<br/>
	 * Para saber mais sobre prioridade de verificação de segurança dinâmica consulte a documentação do Mosquitto
	 * @see <a href="https://mosquitto.org/documentation/dynamic-security/">Mosquitto Documentation</a>
	 */
	public JsonObject addRoleWithPriorityCommand(DynSecRole role, Integer priority) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.ADD_CLIENT_ROLE.getDescription());
		command.addProperty("username", client.getUsername());
		command.addProperty("rolename", role.getRolename());
		command.addProperty("priority", priority);
		return command;
	}

	/**
	 * @param role Objeto do tipo DynSecRole a ser removido do client
	 * @return Retorna um JsonObject contendo o comando para remover uma role de um client
	 */
	public JsonObject removeRoleCommand(DynSecRole role) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.REMOVE_CLIENT_ROLE.getDescription());
		command.addProperty("username", client.getUsername());
		command.addProperty("rolename", role.getRolename());
		return command;
	}

	/**
	 * @return Retorna um JsonObject contendo o comando para deletar um client
	 */
	public JsonObject deleteCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.DELETE_CLIENT.getDescription());
		command.addProperty("username", client.getUsername());
		return command;
	}

	/**
	 * @return Retorna um JsonObject contendo o comando para desabilitar um client
	 */
	public JsonObject disableCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.DISABLE_CLIENT.getDescription());
		command.addProperty("username", client.getUsername());
		return command;
	}

	/**
	 * @return Retorna um JsonObject contendo o comando para habilitar um client
	 */
	public JsonObject enableCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.ENABLE_CLIENT.getDescription());
		command.addProperty("username", client.getUsername());
		return command;
	}

	/**
	 * @return Retorna um JsonObject contendo o comando para buscar um client
	 */
	public JsonObject getClientCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.GET_CLIENT.getDescription());
		command.addProperty("username", client.getUsername());
		return command;
	}

	/**
	 * @return Retorna um JsonObject contendo o comando para listar os clients
	 */
	public JsonObject listClientsCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.LIST_CLIENT.getDescription());
		return command;
	}

	public DynSecClient getClient() {
		return client;
	}

	public void setClient(DynSecClient client) {
		this.client = client;
	}

}
