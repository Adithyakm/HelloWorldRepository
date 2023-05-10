package room;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.socket.engineio.server.EngineIoServer;
import io.socket.socketio.server.SocketIoServer;

@WebServlet(urlPatterns="/socket.io/*",asyncSupported=true)
public class SocketIOJavaServerHelloWorld extends HttpServlet{
   
	private final EngineIoServer mEngineIoServer = new EngineIoServer();
    private final SocketIoServer mSocketIoServer = new SocketIoServer(mEngineIoServer);
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Sock servlet called");
		mEngineIoServer.handleRequest(req, resp);
		handleSocket();
	}
	
	public void handleSocket() {
		SocketIOServerClass.SocketIoServerImpl(mSocketIoServer);
	}
	
}
