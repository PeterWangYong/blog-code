const expressJwt = require('express-jwt')
const {privateKey} = require('../config/setting')

const jwtAuth = expressJwt({
  secret: privateKey,
  credentialsRequired: true
}).unless({
  path: [
    '/user/login'
  ]
})

module.exports = jwtAuth
