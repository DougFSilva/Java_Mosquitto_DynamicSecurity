package br.com.MosquittoDynamicSecurity.dynsec.role;

import com.google.gson.JsonObject;

import br.com.MosquittoDynamicSecurity.dynsec.DynSecCommandType;
import br.com.MosquittoDynamicSecurity.dynsec.role.ACL.DynSecACL;

public class RoleCommand {

	private DynSecRole role;

	public RoleCommand() {
	}

	public RoleCommand(DynSecRole role) {
		this.role = role;
	}

	public JsonObject createCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.CREATE_ROLE.getDescription());
		command.addProperty("rolename", role.getRolename());
		return command;
	}

	public JsonObject deleteCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.DELETE_ROLE.getDescription());
		command.addProperty("rolename", role.getRolename());
		return command;
	}

	public JsonObject addRoleACLCommand(DynSecACL ACL) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.ADD_ROLE_ACL.getDescription());
		command.addProperty("rolename", role.getRolename());
		command.addProperty("acltype", ACL.getAclType().getDescription());
		command.addProperty("topic", ACL.getTopic());
		command.addProperty("allow", ACL.isAllow());
		return command;
	}
	
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

	public JsonObject removeRoleACLCommand(DynSecACL ACL) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.ADD_ROLE_ACL.getDescription());
		command.addProperty("rolename", role.getRolename());
		command.addProperty("acltype", ACL.getAclType().getDescription());
		command.addProperty("topic", ACL.getTopic());
		return command;
	}

	public JsonObject getRoleCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.GET_ROLE.getDescription());
		command.addProperty("rolename", role.getRolename());
		return command;
	}

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
