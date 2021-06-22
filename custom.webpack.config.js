// var webpack = require('webpack');

// module.exports = require('./scalajs.webpack.config');

const { merge } = require('webpack-merge');
var generated = require('./scalajs.webpack.config');

var local = {
    "output": {
        "filename": "main.bundle.js"
    }
}

module.exports = merge(generated, local);