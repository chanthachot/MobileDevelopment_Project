var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mysql = require('mysql');

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
extended: true
}));

// default route
app.get('/', function (req, res) {
return res.send({ error: true, message: 'Test Web API' })
});

// connection configurations
var dbConn = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'trader'
});

// connect to database
dbConn.connect();

// Retrieve item
app.get('/item', function (req, res) {
    dbConn.query('SELECT * FROM item_detail,user WHERE item_detail.username = user.username ORDER by item_detail_id DESC', function (error, results, fields) {
        if (error) throw error;
        return res.send(results);
    });
});


//addItem
app.post('/addItem', function (req, res) {
    var data = req.body
    if (!data ) {
        return res.status(400).send({ error:true, message: 'Please Register Again' });
    }
    dbConn.query("INSERT INTO item_detail SET ? ", data, function (error, results, fields) {
        if (error) throw error;
        return res.send(results);
    });
});


//login
app.post('/login', function(req, res) {
    var data = req.body;
	var username = data.username;
	var password = data.password;
	
		dbConn.query('SELECT * From user WHERE username = ? AND password = ?', [username,password], function(error, results, fields) {
			dbConn.on('error',function(err){
				console.log('[MySQL Error]',err)
		});
		
		if(results && results.length){
			res.end(JSON.stringify(results[0]))
		}
		else {
			res.end(JSON.stringify('Wrong Password'));
		}
	});
});

//register
app.post('/register', function (req, res) {
    var data = req.body
    if (!data ) {
        return res.status(400).send({ error:true, message: 'Please Register Again' });
    }
    dbConn.query("INSERT INTO user SET ? ", data, function (error, results, fields) {
        if (error) throw error;
        return res.send(results);
    });
});


// set port
app.listen(3000, function () {
    console.log('Node app is running on port 3000');
});

module.exports = app;