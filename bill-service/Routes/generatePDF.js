const fs = require('fs');
const PDFDocument = require('pdfkit');
const moment = require("moment/moment");

const generatePDF = (billData, outputPath) => {
    const doc = new PDFDocument();
    const stream = fs.createWriteStream(outputPath);

    doc.pipe(stream);

    // En-tête de la facture
    doc.fontSize(18).text(`FACTURE N° ${billData.billNumber}`, { align: 'center' });
    doc.moveDown(0.5);
    const formattedDate = moment(billData.date).format('MMMM D, YYYY');
    doc.fontSize(12).text(`Date: ${formattedDate}`);
    doc.text(`Référence: ${billData.billNumber}`);
    doc.text(`Client: ${billData.customerEmail}`);
    doc.moveDown(0.5);

    // Autres détails et tableau si nécessaire
    // ...

    // Total
    doc.moveDown(1);
    doc.fontSize(14).text(`Total: ${billData.amount} D`, { align: 'right' });

    doc.end();
};

module.exports = generatePDF;

