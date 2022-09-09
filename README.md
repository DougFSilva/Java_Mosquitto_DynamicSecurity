# Java_Mosquitto_DynamicSecurity
Este código tem a finalidade de realizar a configuração de segurança dinâmica do Broker Mosquitto. Utilizando a segurança dinâmica é possível criar usuários, grupos, permissões sem a necessidade de reiniciar o Broker.
Para mais informações sobre o funcionamento da segurança dinâmica do mosquitto acesse [Mosquitto Documentation](https://mosquitto.org/documentation/dynamic-security/)

---
## 📋 Pré-requisitos
Do que você precisa para utilizar o projeto

Instalar o Mosquitto: 
[Link para download](https://mosquitto.org/download/) 

---
## 🚀 Começando
Estas instruções permitirão que você utilize o projeto e configure a segurança do seu Broker Mosquitto.

### 1. Editar o arquivo mosquitto.conf
Este arquivo se encontra na pasta de instalação do Mosquitto.

Inclua o seguinte no arquivo mosquitto.conf:

Para Linux/BSD:
```
allow_anonymous false
per_listener_settings false
plugin <path>/mosquitto_dynamic_security.so
plugin_opt_config_file <path>/dynamic-security.json
``` 
Para Windows:
```
allow_anonymous false
per_listener_settings false
plugin <path>\mosquitto_dynamic_security.dll
plugin_opt_config_file <path>\dynamic-security.json
```

<span style="color:orange">**Obs.:** path é o caminho da pasta de instalação do Mosquitto. Por exemplo, se o Mosquitto foi instalado em Documents em um Windows o comando seria:</span>

<span style="color:orange">_plugin_opt_config_file c:\Users\fulano\Documents\mosquitto\dynamic-security.json_ </span>

---
### 2. Criar o arquivo dynamic-security.json na pasta de instalação do Mosquitto
Abrir o terminal, navegar até a pasta de instalação do Mosquitto e executar o comando:
```
mosquitto_ctrl dynsec init <path>\dynamic-security.json <admin-user>
```
**_admin-user_** é o nome do usuário admin desejado. Será solicitado que seja digitado a senha desejada para o usuário

---
### 3. Iniciar o Mosquitto
Com o terminal aberto na pasta de instalação do mosquitto execute o seguinte comando:

```
mosquitto -c <path>\mosquitto.conf -v
```
---
### 4. Configurar o acesso padrão
Com o Mosquitto rodando, configurar o acesso padrão para que todo client criado posteriormente já inicie com as permissões bloqueadas. Para isso serão necessários os seguintes comandos (lembrar de estar com o terminal aberto na pasta de instalação do Mosquitto)

```
mosquitto_ctrl -u <usuário> -P <password> -h <hostname> -p <port> dynsec setDefaultACLAccess publishClientSend deny
```
```
mosquitto_ctrl -u <usuário> -P <password> -h <hostname> -p <port>  dynsec setDefaultACLAccess publishClientReceive deny 
```
```
mosquitto_ctrl -u <usuário> -P <password> -h <hostname> -p <port>  dynsec setDefaultACLAccess subscribe deny 
```
```
mosquitto_ctrl -u <usuário> -P <password> -h <hostname> -p <port>  dynsec setDefaultACLAccess unsubscribe deny
```

onde:

**_usuário_** - Usuário admin criado no passo 2
**_password_** - Password do usuário admin criado no passo 2
**_hostname_** - Hostname no Mosquitto (por exemplo localhost)
**_port_** - porta (a porta padrão do Mosquitto é 1883)

---
### 5. Baixar o jar e inserir no classPath

Baixar o arquivo MosquittoDynSec.jar da pasta jar e inserir no classPath do projeto desejado

## Utilização

### Criando um publisher

```
    DynSecPublisher publisher = new DynSecPublisher();
```

### Criando um client

```
	DynSecClient client = new DynSecClient("client10", "passwordClient10");
	publisher.addCommand(client.createCommand())
			 .publish();
```

### Criando uma role

```
	DynSecRole role = new DynSecRole("role0");
	publisher.addCommand(role.createCommand())
			 .publish();
```

### Adicionando uma ACL a role criada no passo anterior

```
    DynSecACL acl = new DynSecACL(ACLType.PUBLISH_CLIENT_RECEIVE, "tópico0", true);
	publisher.addCommand(role.addRoleACLCommand(acl))
			 .publish();
```

### Adicionando a role ao client

```
    publisher.addCommand(client.addRoleCommand(role))
		 .publish();
```

### De uma forma mais enxuta o código inteiro ficaria:

```
	DynSecPublisher publisher = new DynSecPublisher();
	DynSecClient client = new DynSecClient("client10", "passwordClient10");
	DynSecRole role = new DynSecRole("role0");
	DynSecACL acl = new DynSecACL(ACLType.PUBLISH_CLIENT_RECEIVE, "tópico0", true);
	publisher.addCommand(client.createCommand())
			 .addCommand(role.createCommand())
			 .addCommand(role.addRoleACLCommand(acl))
			 .addCommand(client.addRoleCommand(role))
			 .publish();
```

### Também é possível criar grupos, adicionar uma role a um grupo e incluir clients nesse grupo. Veja o exemplo a seguir:

```
    DynSecPublisher publisher = new DynSecPublisher();
	DynSecGroup group = new DynSecGroup("group10");
	DynSecRole role = new DynSecRole("role10");
	DynSecClient client = new DynSecClient("client10", "passwordClient10");
	DynSecACL acl = new DynSecACL(ACLType.PUBLISH_CLIENT_RECEIVE, "tópico10", true);
	publisher.addCommand(group.createCommand())
			 .addCommand(role.createCommand())
			 .addCommand(client.createCommand())
			 .addCommand(role.addRoleACLCommand(acl))
			 .addCommand(group.addRoleCommand(role)) 
			 .addCommand(group.addClientCommand(client))
			 .publish(); // publica

```

Para os demais comandos possíveis e informações, veja em [Java-Mosquitto-DynamicSecurity-javadoc](https://dougfsilva.github.io/Java_Mosquitto_DynamicSecurity/)

---
## 🛠️Construído com

* Spring boot
* Dependências: org.eclipse.paho e com.google.gson
---
## ✒️ Autor
* Douglas Ferreira da Silva





