package br.com.MosquittoDynamicSecurity.dynsec.role;

import com.google.gson.JsonObject;

import br.com.MosquittoDynamicSecurity.dynsec.DynSecCommandType;
import br.com.MosquittoDynamicSecurity.dynsec.ACL.DynSecACL;

/**
 * A classe <b>RoleCommand</b> possui métodos que retornam um JsonObject contendo comandos para configuração de role
 * do Broker Mosquitto. Os objetos JsonObject retornados podem ser inseridos na classe <b>DynSecPublisher</b> pelo método 
 * <i>addCommand(JsonObject command)</i> e publicados no tópico de segurança dinâmica do Broker pelo método <i>publish()</i>
 * @author Douglas Ferreira da Silva
 * @since Set 2022
 * @version 1.0
 */
public class RoleCommand {

	private DynSecRole role;

	public RoleCommand() {
	}

	public RoleCommand(DynSecRole role) {
		this.role = role;
	}

	/**
	 * @return Retorna um JsonObject contendo o comando para criar uma role
	 */
	public JsonObject createCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.CREATE_ROLE.getDescription());
		command.addProperty("rolename", role.getRolename());
		return command;
	}

	/**
	 * @return Retorna um JsonObject contendo o comando para deletar uma role
	 */
	public JsonObject deleteCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.DELETE_ROLE.getDescription());
		command.addProperty("rolename", role.getRolename());
		return command;
	}
	
	/**
	 * @param ACL Objeto do tipo DynSecACL a ser adicionado a uma role
	 * @return Retorna um JsonObject contendo o comando para adicionar uma ACL a uma role
	 */
	public JsonObject addRoleACLCommand(DynSecACL ACL) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.ADD_ROLE_ACL.getDescription());
		command.addProperty("rolename", role.getRolename());
		command.addProperty("acltype", ACL.getAclType().getDescription());
		command.addProperty("topic", ACL.getTopic());
		command.addProperty("allow", ACL.isAllow());
		return command;
	}
	
	/**
	 * @param ACL Objeto do tipo DynSecACL a ser adicionado a uma role
	 * @param priority Valor inteiro da prioridade que se deseja configurar 
	 * @return Retorna um JsonObject contendo o comando para adicionar uma ACL a uma role com definição de prioridade<br/>
	 * Para saber mais sobre prioridade de verificação de segurança dinâmica consulte a documentação do Mosquitto
	 * @see <a href="https://mosquitto.org/documentation/dynamic-security/">Mosquitto Documentation</a>
	 */
	public JsonObject addRoleACLWithPriorityCommand(DynSecACL ACL, Integer priority) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.ADD_ROLE_ACL.getDescription());
		command.addProperty("rolename", role.getRolename());
		command.addProperty("acltype", ACL.getAclType().getDescription());
		command.addProperty("topic", ACL.getTopic());
		command.addProperty("allow", ACL.isAllow());
		command.addProperty("priority", priority);
		return command;
	}

	/**
	 * @param ACL Objeto do tipo DynSecACL a ser removido de uma role
	 * @return Retorna um JsonObject contendo o comando para remover uma ACL de uma role
	 */
	public JsonObject removeRoleACLCommand(DynSecACL ACL) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.REMOVE_ROLE_ACL.getDescription());
		command.addProperty("rolename", role.getRolename());
		command.addProperty("acltype", ACL.getAclType().getDescription());
		command.addProperty("topic", ACL.getTopic());
		return command;
	}

	/**
	 * @return Retorna um JsonObject contendo o comando para buscar uma role
	 */
	public JsonObject getRoleCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.GET_ROLE.getDescription());
		command.addProperty("rolename", role.getRolename());
		return command;
	}

	/**
	 * @return Retorna um JsonObject contendo o comando para listar roles
	 */
	public JsonObject listRolesCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.LIST_ROLE.getDescription());
		return command;
	}

	public DynSecRole getRole() {
		return role;
	}

	public void setRole(DynSecRole role) {
		this.role = role;
	}

}
