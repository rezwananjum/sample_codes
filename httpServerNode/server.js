var connect = require('connect');
var http = require('http');

var app = connect();
app.use(doFirst);
app.use(doSecond);
app.use('/home',home);
function home(request,response){
  console.log("we are now in home page");

}
function doFirst(request,response,next){
  console.log("rnning doFirst");
  next();

}
function doSecond(request,response,next){
 console.log("running second");
 next();
}

http.createServer(app).listen(8888);
console.log("server is running");
