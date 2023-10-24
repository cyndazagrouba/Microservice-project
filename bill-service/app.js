const mongoose = require('mongoose');
require('dotenv').config();


const express = require('express');
const app = express();
const connectDB =require('./Config/db')

const billRoutes = require('./Routes/BillRoute');

const generatePDF = require('./Routes/generatePDF');
app.use('/bills', billRoutes);

app.use(express.json());

app.use(billRoutes);
app.use(generatePDF);

mongoose.connection.once('open', () => {
    console.log('Connected to MongoDB')
    app.listen(port, () => console.log(`Server running on port ${port}`))
})

mongoose.connection.on('error', err => {
    console.log(err)
    // logEvents(`${err.no}: ${err.code}\t${err.syscall}\t${err.hostname}`, 'mongoErrLog.log')
})









const port = process.env.PORT || 2000;
connectDB();
