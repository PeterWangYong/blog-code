const errorHandler = function(err, req, res, next) {
  if (err.name === 'UnauthorizedError') {
    res.status(err.status).send({
      code: -2,
      msg: 'Token不存在或者已过期'
    })
  } else {
    const status = err.output && err.output.statusCode || 500
    res.status(status).send({
      code: -1,
      msg: (err && err.message) || '未知错误'
    })
  }
}

module.exports = errorHandler
