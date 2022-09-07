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

	public JsonObject getCreateCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.CREATE_CLIENT.getDescription());
		command.addProperty("username", client.getUsername());
		command.addProperty("password", client.getPassword());
		return command;
	}

	public JsonObject getCreateWithIdCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.CREATE_CLIENT.getDescription());
		command.addProperty("username", client.getUsername());
		command.addProperty("password", client.getPassword());
		return command;
	}

	public JsonObject getAddRoleCommand(DynSecRole role) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.ADD_CLIENT_ROLE.getDescription());
		command.addProperty("username", client.getUsername());
		command.addProperty("rolename", role.getRolename());
		return command;
	}

	public JsonObject getAddRoleWithPriorityCommand(DynSecRole role, Integer priority) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.ADD_CLIENT_ROLE.getDescription());
		command.addProperty("username", client.getUsername());
		command.addProperty("rolename", role.getRolename());
		command.addProperty("priority", priority);
		return command;
	}

	public JsonObject getRemoveRoleCommand(DynSecRole role) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.REMOVE_CLIENT_ROLE.getDescription());
		command.addProperty("username", client.getUsername());
		command.addProperty("rolename", role.getRolename());
		return command;
	}

	public JsonObject getDeleteCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.DELETE_CLIENT.getDescription());
		command.addProperty("username", client.getUsername());
		return command;
	}

	public JsonObject getDisableCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.DISABLE_CLIENT.getDescription());
		command.addProperty("username", client.getUsername());
		return command;
	}

	public JsonObject getEnableCommand() {
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

	public JsonObject getListClientsCommand() {
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
