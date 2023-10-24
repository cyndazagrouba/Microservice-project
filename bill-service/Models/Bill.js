const mongoose = require('mongoose');

const billSchema = new mongoose.Schema({
    billNumber: {
        type: String,
        required: true,
        unique: true,

    },
    amount: {
        type: String,
        required: true,

    },
    date: Date,

    isPaid: {
        type: Boolean,
        default: false, // Initially, the bill is marked as unpaid
    }
});

const Bill = mongoose.model('Bill', billSchema);

module.exports = Bill;
