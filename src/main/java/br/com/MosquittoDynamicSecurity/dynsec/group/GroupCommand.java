package br.com.MosquittoDynamicSecurity.dynsec.group;

import com.google.gson.JsonObject;

import br.com.MosquittoDynamicSecurity.dynsec.DynSecCommandType;
import br.com.MosquittoDynamicSecurity.dynsec.client.DynSecClient;
import br.com.MosquittoDynamicSecurity.dynsec.role.DynSecRole;

public class GroupCommand {

	private DynSecGroup group;

	public GroupCommand(DynSecGroup group) {
		this.group = group;
	}

	public JsonObject createCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.CREATE_GROUP.getDescription());
		command.addProperty("groupname", group.getGroupname());
		return command;
	}

	public JsonObject deleteCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.DELETE_GROUP.getDescription());
		command.addProperty("groupname", group.getGroupname());
		return command;
	}

	public JsonObject addClientCommand(DynSecClient client) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.ADD_GROUP_CLIENT.getDescription());
		command.addProperty("groupname", group.getGroupname());
		command.addProperty("username", client.getUsername());
		return command;
	}

	public JsonObject addClientWithPriorityCommand(DynSecClient client, Integer priority) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.ADD_GROUP_CLIENT.getDescription());
		command.addProperty("groupname", group.getGroupname());
		command.addProperty("username", client.getUsername());
		command.addProperty("priority", priority);
		return command;
	}

	public JsonObject removeClientCommand(DynSecClient client) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.REMOVE_GROUP_CLIENT.getDescription());
		command.addProperty("groupname", group.getGroupname());
		command.addProperty("username", client.getUsername());
		return command;
	}

	public JsonObject addRoleCommand(DynSecRole role) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.ADD_GROUP_ROLE.getDescription());
		command.addProperty("groupname", group.getGroupname());
		command.addProperty("rolename", role.getRolename());
		return command;
	}

	public JsonObject addRoleWithPriorityCommand(DynSecRole role, Integer priority) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.ADD_GROUP_ROLE.getDescription());
		command.addProperty("groupname", group.getGroupname());
		command.addProperty("rolename", role.getRolename());
		command.addProperty("priority", priority);
		return command;
	}

	public JsonObject removeRoleCommand(DynSecRole role) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.REMOVE_GROUP_ROLE.getDescription());
		command.addProperty("groupname", group.getGroupname());
		command.addProperty("rolename", role.getRolename());
		return command;
	}

	public JsonObject getAnonymousCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.GET_ANONYMOUS_GROUP.getDescription());
		return command;
	}

	public JsonObject setAnonymousCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.SET_ANONYMOUS_GROUP.getDescription());
		command.addProperty("groupname", group.getGroupname());
		return command;
	}

	public JsonObject getGroupCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.GET_GROUP.getDescription());
		command.addProperty("groupname", group.getGroupname());
		return command;
	}

	public JsonObject listGroupsCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.LIST_GROUP.getDescription());
		return command;
	}

	public DynSecGroup getGroup() {
		return group;
	}

	public void setGroup(DynSecGroup group) {
		this.group = group;
	}

}
