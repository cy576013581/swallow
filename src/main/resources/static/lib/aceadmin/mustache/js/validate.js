var fs    = require('fs'),
	w3cjs = require('w3cjs')
var output_dir = __dirname + '/output_folder'

var files = fs.readdirSync(output_dir)
files.forEach(function (name) {
	if (! name.match(/(.+?)\.(html)$/) ) return

	var results = w3cjs.validate({
		file: output_dir+'/'+name,
		output: 'json',
		callback: function (res) {
			console.log(name + " validation result")
			console.log(res)
		}
	});
})
