const boom = require('boom')

const notFound = function(req, res, next) {
  next(boom.notFound('资源不存在'))
}

module.exports = notFound
