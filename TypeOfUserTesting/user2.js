var movies = require('./movies');

var user2Movies =  movies();

user2Movies.favMovies = "B";
console.log("fav movie is :" + user2Movies.favMovies);