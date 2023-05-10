package room;

import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.socket.engineio.server.Emitter;
import io.socket.socketio.server.SocketIoNamespace;
import io.socket.socketio.server.SocketIoServer;
import io.socket.socketio.server.SocketIoSocket;

public class SocketIOServerClass {
	
	public static void SocketIoServerImpl(SocketIoServer mSocketIoServer) {
		SocketIoNamespace ns = mSocketIoServer.namespace("/");
		ns.on("connection", new Emitter.Listener() {
			
			@Override
			public void call(Object... args) {
				// TODO Auto-generated method stub
				final SocketIoSocket socket = (SocketIoSocket) args[0];
				System.out.println("client connected : "+socket.getId());
				socket.on("HelloWorld", new Emitter.Listener() {
					
					@Override
					public void call(Object... args) {
						// TODO Auto-generated method stub
						//System.out.println(args[0]);
						ObjectMapper objectMapper = new ObjectMapper();
						String json = args[0].toString();
						//System.out.println(json);
						try {
							HelloWorldObject obj=objectMapper.readValue(json, HelloWorldObject.class);
							System.out.println("Received the event frpm client and its value is : "+obj.getValue());
							JSONObject object = new JSONObject(obj);
							System.out.println(object.toString());
							socket.send("HelloReturned",object);
							System.out.println("HelloReturned event sent to the client");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				//		HelloWorldObject obj = objectMapper.readValue(args[0], HelloWorldObject.class);
				//		System.out.println("Message received from client : "+obj.getValue());
						
					}
				});
			}
		});
	}

}
