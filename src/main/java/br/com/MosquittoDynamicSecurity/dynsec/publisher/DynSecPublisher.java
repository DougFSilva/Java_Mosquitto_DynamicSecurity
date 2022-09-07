package br.com.MosquittoDynamicSecurity.dynsec.publisher;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * A classe <b>DynSecPublisher</b> é responsável por receber os comandos de
 * client, role e group e publicar no tópico de controle de segurança dinâmica
 * do Mosquitto. Ela implementa a interface <b>MqttCallback</b> para receber a
 * resposta dos comandos enviados e imprimir no console.
 * 
 * @author Douglas Ferreira da Silva
 * @since Set 2022
 * @version 1.0
 */
public class DynSecPublisher implements MqttCallback {

	/**
	 * uri do Broker mosquitto
	 */
	private final String uri;

	private final String username;

	private final String password;

	private final String clientId;

	/**
	 * tópico para fazer a publicação dos comandos de segurança dinâmmica
	 */
	private final String topicToPublish;

	/**
	 * tópico da segurança dinâmica do Mosquitto para fazer subscribe e receber a
	 * resposta dos comandos publicados
	 */
	private final String topicToSubscribe;

	private JsonArray commands;

	/**
	 * Construtor que faz a leitura das propriedades contidas no arquivo
	 * <b>application.properties</b> e insere nos atributos da classe
	 */
	public DynSecPublisher() {
		Properties properties = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream("src/main/resources/application.properties");
			properties.load(file);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
		uri = properties.getProperty("mqtt.uri");
		username = properties.getProperty("mqtt.admin.username");
		password = properties.getProperty("mqtt.admin.password");
		clientId = properties.getProperty("mqtt.admin.clientId");
		topicToPublish = "$CONTROL/dynamic-security/v1";
		topicToSubscribe = "$CONTROL/dynamic-security/v1/#";
		this.commands = new JsonArray();
	}

	/**
	 * Método para adicionar comandos a serem executados pelo método
	 * <i>publish()</i>
	 * @param command Objeto do tipo JsonObject contendo os comandos a serem publicados
	 * @return Retorna a própria classe permitindo o encadeamento de métodos
	 */
	public DynSecPublisher addCommand(JsonObject command) {
		this.commands.add(command);
		return this;
	}

	/**
	 * Método para limpar a lista de comandos a serem executados pelo método
	 * <i>publish()</i>
	 * @return Retorna a própria classe permitindo o encadeamento de métodos
	 */
	public DynSecPublisher removeCommands() {
		this.commands.forEach(command -> this.commands.remove(command));
		return this;
	}

	/**
	 * Método utilizado para executar/publicar os comandos adicionados ao atributo
	 * commands.
	 */
	public void publish() {
		JsonObject payload = new JsonObject();
		payload.add("commands", commands);
		try {
			MqttClient client = new MqttClient(uri, clientId, new MemoryPersistence());
			MqttConnectOptions options = new MqttConnectOptions();
			options.setCleanSession(true);
			options.setUserName(username);
			options.setPassword(password.toCharArray());
			client.connect(options);
			MqttMessage message = new MqttMessage();
			message.setQos(2);
			message.setRetained(false);
			message.setPayload(payload.toString().getBytes());
			client.subscribe(topicToSubscribe);
			client.setCallback(this);
			client.publish(topicToPublish, message);
			client.unsubscribe(topicToSubscribe);
			client.disconnect();
		} catch (MqttException e) {
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
	}

	/**
	 * Método da interface MqttCallback que é executado ao perder a conexão com o
	 * Broker Mosquitto
	 */
	@Override
	public void connectionLost(Throwable cause) {
		System.out.println("Connection lost! cause: " + cause);
	}

	/**
	 * Método da interface MqttCallback que é executado ao receber uma mensagem no
	 * tópico no qual foi feito o subscribe
	 */
	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println("--------------------Message Received of Mosquitto Dynamic Security------------------");
		System.out.println("topic: " + topic);
		System.out.println("message: " + message);
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {

	}

	public String getUri() {
		return uri;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getClientId() {
		return clientId;
	}

	public String getTopicToPublish() {
		return topicToPublish;
	}

	public String getTopicToSubscribe() {
		return topicToSubscribe;
	}

	@Override
	public String toString() {
		return "DynSecPublisher [uri=" + uri + ", username=" + username + ", password=" + password + ", clientId="
				+ clientId + ", topicToPublish=" + topicToPublish + ", topicToSubscribe=" + topicToSubscribe
				+ ", commands=" + commands + "]";
	}

}
