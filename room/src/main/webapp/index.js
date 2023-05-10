//const  socket = io({transportOptions:{
//	Polling:{
//	extraHeaders:
//	{'X-Host':window.location.hostname,'X-Port' : window.location.port||9891}
//	}
//},
//transports:['polling'],
//path:'/',
//allowEIO3 : true,
//withCredentials:true,
//reconnectionDelay : 1000,
//reconnectionAttempts:21000,
//timeout:30000,
//namespace:"/"
//}
//);

/*var socket = io.connect("http://localhost:9894/socket.io/*");

var jsonObject = {'@class' : 'room.HelloWorldObject',
                   value : 'Hello World'}


socket.on('connect',()=>{
	console.log("connected to server");
	socket.emit("Hello",jsonObject);
});

socket.on('HelloReturned',(args)=>{
	console.log("Hello Returned Event emitted from server");
	document.getElementById("eventvalue").innerHTML=args.value
})*/

var socket=null;

var jsonObject = {value : 'Hello World'}

function createLogin(){
	
	  socket = io({transportOptions:{
	Polling:{
	extraHeaders:
	{'X-Host':window.location.hostname,'X-Port' : window.location.port||9891}
	}
},
transports:['polling'],
path:'/socket.io',
allowEIO3 : true,
withCredentials:true,
reconnectionDelay : 1000,
reconnectionAttempts:21000,
timeout:30000,
namespace:"/"
}
);
//socket = io("http://localhost:9891/socket.io/*");
/*socket = io('http://localhost:9891', {
  transportOptions: {
    polling: {
      extraHeaders: {
        'X-Host': window.location.hostname,
        'X-Port': window.location.port || 9891
      }
    }
  },
  transports: ['polling'],
  path: '/socket.io',
  allowEIO3: true,
  withCredentials: true,
  reconnectionDelay: 1000,
  reconnectionAttempts: 21000,
  timeout: 30000,
  namespace: '/'
});*/

socket.on('connect',(args)=>{
	console.log("connected to server");
	document.getElementById("login").classList.add('d-none');
	console.log(document.getElementById("login").classList);
	socket.emit("HelloWorld",jsonObject);
	console.log("Hello World event emitted from client");
	socket.on("HelloReturned",(args)=>{	
	console.log("Helloreturned event emitted from server");
	console.log(args);
	document.getElementById("eventvalue").innerHTML=args.value
	document.getElementById("logout").classList.remove('d-none');
})
})
	
}

/*socket.on("HelloReturned",(args)=>{
	console.log("Helloreturned event emitted from server");
	document.getElementById("eventvalue").innerHTML=args.value
	document.getElementById("logout").classList.remove('d-none');
})*/

function doLogout(){
	socket.close();
	console.log("connection closed");
	document.getElementById("login").classList.remove('d-none');
	document.getElementById("logout").classList.add('d-none');
	document.getElementById("eventvalue").innerHTML=""
	
	
}







