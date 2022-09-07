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

	public JsonObject getCreateCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.CREATE_ROLE.getDescription());
		command.addProperty("rolename", role.getRolename());
		return command;
	}

	public JsonObject getDeleteCommand() {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.DELETE_ROLE.getDescription());
		command.addProperty("rolename", role.getRolename());
		return command;
	}

	public JsonObject getAddRoleACLCommand(DynSecACL ACL) {
		JsonObject command = new JsonObject();
		command.addProperty("command", DynSecCommandType.ADD_ROLE_ACL.getDescription());
		command.addProperty("rolename", role.getRolename());
		command.addProperty("acltype", ACL.getAclType().getDescription());
		command.addProperty("topic", ACL.getTopic());
		command.addProperty("allow", ACL.isAllow());
		return command;
	}

	public JsonObject getRemoveRoleACLCommand(DynSecACL ACL) {
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

	public JsonObject GetListRolesCommand() {
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
