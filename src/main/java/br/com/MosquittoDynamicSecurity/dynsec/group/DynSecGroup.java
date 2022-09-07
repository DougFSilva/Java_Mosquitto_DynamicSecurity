package br.com.MosquittoDynamicSecurity.dynsec.group;

public class DynSecGroup {

	private String groupname;

	public DynSecGroup(String groupname) {
		this.groupname = "group_" + groupname;
	}
	
	public String getGroupname() {
		return groupname;
	}

}
