package room;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jetty.server.session.Session;

import com.codeminders.socketio.common.SocketIOException;
import com.codeminders.socketio.server.ConnectionException;
import com.codeminders.socketio.server.ConnectionListener;
import com.codeminders.socketio.server.EventListener;
import com.codeminders.socketio.server.Namespace;
import com.codeminders.socketio.server.Socket;
import com.codeminders.socketio.server.SocketIOServlet;

@WebServlet(urlPatterns = "/socket.io/*",asyncSupported=true)
public class CodemindersSocketIoServer extends SocketIOServlet {

	@Override
	public Namespace namespace(String id) {
		// TODO Auto-generated method stub
		return super.namespace(id);
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		HttpSession session = req.getSession();
		System.out.println("Session details : "+session.getId());
		
		Namespace namespace = namespace("/");
		//Socket socket = namespace.createSocket(session);
		System.out.println("namespace created : "+namespace.getId());
		namespace.on(new ConnectionListener() {

			@Override
			public void onConnect(final Socket socket) throws ConnectionException {
				// TODO Auto-generated method stub
				System.out.println("Client connected successfully");
				System.out.println("connection details : ");
				System.out.println(socket.getSession().getHttpSession().getId());
				socket.on("HelloWorld", new EventListener() {

					@Override
					public Object onEvent(String name, Object[] args, boolean ackRequested) {
						// TODO Auto-generated method stub
						System.out.println(name);
						System.out.println(args[0]);
						try {
							socket.emit("HelloReturned", "Hello World");
						} catch (SocketIOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return ackRequested;
					}
					
				});
			}
			
		});
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	

}
