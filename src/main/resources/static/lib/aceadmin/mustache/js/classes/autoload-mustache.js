//override the function that loads a new template, to make it load partials dynamically based on their path
var autoload = require('./autoload-path');
var fs = require('fs');

module.exports = function(mustache, paths) {
 var $page_name , $layout_name;
 this.set_params = function(page_name , layout_name) {
	$page_name = page_name || 'index';
	$layout_name = layout_name || 'default';
 }

 mustache.Writer.prototype._partial = function (name, context) {
	if (!(name in this._partialCache)) {
		if(this._loadPartial) {
			this.compilePartial(name, this._loadPartial(name));
		}
		else {
			var partial_path = autoload(name , {'page_name' : $page_name , 'layout_name' : $layout_name} , paths);
			if(partial_path != '') mustache.compilePartial(name, fs.readFileSync(partial_path , 'utf-8'));
		}
	}

	var fn = this._partialCache[name];
	return fn ? fn(context) : "";
 }

}