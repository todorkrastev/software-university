const express = require('express');

const app = express()
app.use(express.json())
app.use(express.urlencoded({ extended: true }))

app.post('/', async (req, res, next) => {
    console.log('OUR FORM BODY', req.body);
    next();
})

app.listen(3001, () => {
    console.log("Started on PORT 3001");
})