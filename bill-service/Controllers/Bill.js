//const Bill = require('../Models/Bill');
const express = require('express');
//const router = express.Router();
const mongoose = require('mongoose');

const moment = require('moment');

const Bill = require('../Models/Bill'); // Your Bill model file


const generatePDF = require('../routes/generatePDF'); // Le chemin est relatif au fichier Bill.js

exports.searchBillByParams = async (req, res) => {
    const { billNumber, date, amount, isPaid } = req.query;

    const query = {};

    if (billNumber) {
        query.billNumber = billNumber;
    }

    if (amount) {
        query.amount = amount;
    }

    if (isPaid !== undefined) {
        // Convert the isPaid string to a boolean value
        query.isPaid = isPaid === 'true';
    }

    if (date) {
        // If the date parameter is provided, convert it to a Date object
        query.date = new Date(date);
    }

    try {
        // Perform the search based on the constructed query
        const bills = await Bill.find(query).sort({ date: 'asc' });

        res.json(bills);
    } catch (error) {
        console.error('Error occurred while fetching bills:', error);
        res.status(500).json({ error: 'Error occurred while fetching bills' });
    }
};


exports.createBill = async (req, res) => {
    try {
        const { billNumber, amount, date, isPaid } = req.body;

        // Créez la facture dans la base de données
        const newBill = new Bill({
            billNumber,
            amount,
            date: new Date(date), // Utilisez la date reçue dans la requête
            isPaid,
        });

        const savedBill = await newBill.save();

        // Générez le PDF et enregistrez-le
        generatePDF(savedBill, 'E:/5SAE/monfichier.pdf');


        res.json(savedBill);
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Error creating bill' });
    }
};



exports.getBill = async (req, res) => {
    try {
        const bill = await Bill.findById(req.params.id);
        if (!bill) {
            return res.status(404).json({ error: 'Bill not found' });
        }
        res.json(bill);
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Error fetching bill' });
    }
};

exports.getBill = async (req, res) => {
    const { billNumber, date, amount, isPaid } = req.query;

    const query = {};

    if (billNumber) {
        query.billNumber = billNumber;
    }

    if (date) {
        query.date = new Date(date);
    }

    if (amount) {
        query.amount = amount;
    }

    if (isPaid !== undefined) {
        query.isPaid = isPaid === 'true';
    }

    try {
        const bills = await Bill.find(query).sort({ date: 'asc' });

        res.json(bills);
    } catch (error) {
        console.error('Error occurred while fetching bills:', error);
        res.status(500).json({ error: 'Error occurred while fetching bills' });
    }
};

exports.updateBill = async (req, res) => {
    try {
        const { billNumber, amount, date } = req.body;
        const updatedBill = await Bill.findByIdAndUpdate(
            req.params.id,
            { billNumber, amount, date },
            { new: true }
        );
        if (!updatedBill) {
            return res.status(404).json({ error: 'Bill not found' });
        }
        res.json(updatedBill);
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Error updating bill' });
    }
};

exports.deleteBill = async (req, res) => {
    try {
        const deletedBill = await Bill.findByIdAndRemove(req.params.id);
        if (!deletedBill) {
            return res.status(404).json({ error: 'Bill not found' });
        }
        res.json({ message: 'Bill deleted successfully' });
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Error deleting bill' });
    }
};

exports.getAllBills = async (req, res) => {
    try {
        const bills = await Bill.find({});
        res.json(bills);
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Error fetching bills' });
    }
};

exports.BillState = async (req, res) => {
    try {
        const bill = await Bill.findById(req.params.id);
        if (!bill) {
            return res.status(404).json({ error: 'Bill not found' });
        }

        // Toggle the isPaid state based on the request
        bill.isPaid = req.body.isPaid;
        const updatedBill = await bill.save();

        res.json(updatedBill);
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Error updating bill state' });
    }};
