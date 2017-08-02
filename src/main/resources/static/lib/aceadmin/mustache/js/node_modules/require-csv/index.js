// @see http://nodejs.org/api/all.html#all_require_extensions
var fs = require('fs')
  , csv2array = require('csv2array');

require.extensions['.csv'] = function(module, filename) {
  var content = fs.readFileSync(filename, 'utf8');
  // Parse the file content and give to module.exports
  var content = csv2array(content);
  module.exports = content;
};

