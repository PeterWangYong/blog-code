const express = require('express')
const jwt = require('jsonwebtoken')
const {privateKey} = require('../config/setting')
const jwtDecode = require('../utils/jwtDecode')

const router = express.Router()

router.post('/login', function(req, res) {

  const {username, password} = req.body

  if (username === 'admin' && password === 'password') {
    const token = jwt.sign({username}, privateKey, {expiresIn: '1h'})
    res.send({
      code: 0,
      msg: 'success',
      data: {
        token
      }
    })
  } else {
    return send({
      code: 10000,
      msg: '用户名密码错误'
    })
  }
})

router.get('/info', function(req, res) {
  const payload = jwtDecode(req)
  res.send({
    code: 0,
    msg: 'success',
    data: {
      username: payload.username,
      roles: ['admin']
    }
  })
})

module.exports = router
