package br.com.MosquittoDynamicSecurity.dynsec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.MosquittoDynamicSecurity.dynsec.client.ClientCommand;
import br.com.MosquittoDynamicSecurity.dynsec.client.DynSecClient;
import br.com.MosquittoDynamicSecurity.dynsec.publisher.DynSecPublisher;
import br.com.MosquittoDynamicSecurity.dynsec.role.DynSecRole;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		DynSecPublisher publisher = new DynSecPublisher();
		DynSecClient client = new DynSecClient("Teste0", "012345");
		DynSecRole role = new DynSecRole("Teste0");
		ClientCommand clientCommand = new ClientCommand(client);
		publisher.addCommand(clientCommand.getCreateCommand())
				 .addCommand(clientCommand.getAddRoleCommand(role)).publish();
	}

}
