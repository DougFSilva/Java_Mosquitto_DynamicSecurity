package br.com.MosquittoDynamicSecurity.dynsec;

/**
 * O Enum <b>DynSecCommandType</b> define os comandos possíveis de serem executados no sistema de segurança dinâmica do Mosquitto.
 * @author Douglas Ferreira da Silva
 * @since Set 2022
 * @version 1.0
 */
public enum DynSecCommandType {
	
	// Client
	CREATE_CLIENT("createClient"),
	DELETE_CLIENT("deleteClient"),
	DISABLE_CLIENT("disableClient"),
	ENABLE_CLIENT("enableClient"),
	ADD_CLIENT_ROLE("addClientRole"),
	REMOVE_CLIENT_ROLE("removeClientRole"),
	GET_CLIENT("getClient"),
	LIST_CLIENT("listClients"),
	
	// Role
	CREATE_ROLE("createRole"),
	DELETE_ROLE("deleteRole"),
	ADD_ROLE_ACL("addRoleACL"),
	REMOVE_ROLE_ACL("removeRoleACL"),
	GET_ROLE("getRole"),
	LIST_ROLE("listRoles"),
	
	// Group
	CREATE_GROUP("createGroup"),
	DELETE_GROUP("deleteGroup"),
	ADD_GROUP_CLIENT("addGroupClient"),
	REMOVE_GROUP_CLIENT("removeGroupClient"),
	ADD_GROUP_ROLE("addGroupRole"),
	REMOVE_GROUP_ROLE("addGroupRole"),
	SET_ANONYMOUS_GROUP("setAnonymousGroup"),
	GET_ANONYMOUS_GROUP("getAnonymousGroup"),
	GET_GROUP("getGroup"),
	LIST_GROUP("listGroups"),
	
	// Default ACL
	SET_DEFAULT_ACL_ACCESS("listGroups"),
	GET_DEFAULT_ACL_ACCESS("listGroups");
	
	
	private String description;

	private DynSecCommandType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}
