var movies = require('./movies');

var user1Movies =  movies();

user1Movies.favMovies = "A";
console.log("fav movie is :" + user1Movies.favMovies);