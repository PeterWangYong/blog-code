const jwt = require('jsonwebtoken')
const {privateKey} = require('../config/setting')

function jwtDecode(req) {
  const token = req.get('Authorization').replace('Bearer ', '')
  return jwt.verify(token, privateKey)
}

module.exports = jwtDecode
