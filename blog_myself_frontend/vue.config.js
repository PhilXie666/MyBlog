
/*module.exports = {
    devServer: {
        port: 8080,
        proxy: {
            "/": {
                target: 'http://localhost:8081/',
                changeOrigin: true,
            }
        }
    }
}*/



module.exports = {
    devServer: {
        port: 8080,
        proxy: {
            "/api": {
                target: 'http://localhost:8081/',
                changeOrigin: true,
                pathRewrite: {
                    '^/api' : ''
                }
            }
        }
    }
}
