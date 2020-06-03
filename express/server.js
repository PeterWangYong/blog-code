const express = require('express')
const bodyParser = require('body-parser')
const jwtAuth = require('./midware/jwtAuth')
const errorHandler = require('./midware/errorHandler')
const notFound = require('./midware/notFound')
const indexRouter = require('./routes/index')

const app = express()

app.use(bodyParser.urlencoded({extended: true}))
app.use(bodyParser.json())
app.use(jwtAuth)

app.use('/', indexRouter)

app.use(notFound)
app.use(errorHandler)

const server = app.listen(5000, function() {
  const {address, port} = server.address()
  console.log(`listening at ${address}:${port}`)
})
