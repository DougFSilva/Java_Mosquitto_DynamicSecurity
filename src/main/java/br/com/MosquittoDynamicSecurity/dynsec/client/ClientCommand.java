package br.com.MosquittoDynamicSecurity.dynsec.client;

import com.google.gson.JsonObject;

import br.com.MosquittoDynamicSecurity.dynsec.DynSecCommandType;
import br.com.MosquittoDynamicSecurity.dynsec.role.DynSecRole;

public class ClientCommand {

	private DynSecClient client;

	public ClientCommand() {
	}

	public ClientCommand(DynSecClient client) {
		this.client = client;
	}

	public JsonObject createCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.CREATE_CLIENT.getDescription());
		command.addProperty("username", client.getUsername());
		command.addProperty("password", client.getPassword());
		return command;
	}

	public JsonObject createWithIdCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.CREATE_CLIENT.getDescription());
		command.addProperty("username", client.getUsername());
		command.addProperty("password", client.getPassword());
		return command;
	}

	public JsonObject addRoleCommand(DynSecRole role) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.ADD_CLIENT_ROLE.getDescription());
		command.addProperty("username", client.getUsername());
		command.addProperty("rolename", role.getRolename());
		return command;
	}

	public JsonObject addRoleWithPriorityCommand(DynSecRole role, Integer priority) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.ADD_CLIENT_ROLE.getDescription());
		command.addProperty("username", client.getUsername());
		command.addProperty("rolename", role.getRolename());
		command.addProperty("priority", priority);
		return command;
	}

	public JsonObject removeRoleCommand(DynSecRole role) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.REMOVE_CLIENT_ROLE.getDescription());
		command.addProperty("username", client.getUsername());
		command.addProperty("rolename", role.getRolename());
		return command;
	}

	public JsonObject deleteCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.DELETE_CLIENT.getDescription());
		command.addProperty("username", client.getUsername());
		return command;
	}

	public JsonObject disableCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.DISABLE_CLIENT.getDescription());
		command.addProperty("username", client.getUsername());
		return command;
	}

	public JsonObject enableCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.DISABLE_CLIENT.getDescription());
		command.addProperty("username", client.getUsername());
		return command;
	}

	public JsonObject getClientCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.GET_CLIENT.getDescription());
		command.addProperty("username", client.getUsername());
		return command;
	}

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
