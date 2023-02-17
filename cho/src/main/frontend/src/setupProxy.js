// src/main/frontend/src/setupProxy.js

const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
    app.use(
        '/api',
        createProxyMiddleware({
            // 2023.02.18: 원하는 서버 URL or localhost 포트번호
            target: 'http://localhost:8080',
    changeOrigin: true,
})
);
};