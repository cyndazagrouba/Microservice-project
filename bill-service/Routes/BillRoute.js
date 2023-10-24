const express = require('express');
const router = express.Router();
const billController = require('../Controllers/Bill');

// Create a new bill
router.post('/bill', billController.createBill);

// Retrieve a specific bill by ID
router.get('/bill/:id', billController.getBill);

// Delete a bill by ID
router.delete('/bill/:id', billController.deleteBill);

router.get('/bills', billController.getAllBills);

router.put('/bill/state/:id', billController.BillState);

module.exports = router;

// Assurez-vous d'importer la fonction de génération PDF correcte

router.get('/bill/search', billController.searchBillByParams);
const generatePDF = require('../Routes/generatePDF');


// Route pour générer un PDF de facture
router.get('/generate-pdf', (req, res) => {
    // Données facture de test (remplacez-les par les données de votre facture)
    const billData = {
        billNumber: '1234567890',
        amount: '123.45',
        date: new Date(),
        isPaid: false,
    };

    // Générez le PDF et renvoyez-le en réponse à la requête
   generatePDF(billData, 'E:/5SAE/monfichier.pdf'); // Spécifiez le chemin où vous souhaitez enregistrer le PDF


});

module.exports = router;
