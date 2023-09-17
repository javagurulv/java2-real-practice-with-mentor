package org.javaguru.mentor.lesson_7.homework.level_4_junior.solutions;

class CashReceiptCalculator {

    public double calculateTotalSalesSum(CashReceipt[] receipts) {
        double totalSum = 0.0;
        for (int i = 0; i < receipts.length; i++) {
            CashReceipt receipt = receipts[i];
            totalSum += receipt.getSum();
        }
        return totalSum;
    }

    public double calculateAverageReceiptSum(CashReceipt[] receipts) {
        if (receipts.length == 0) {
            return 0.0;
        } else {
            double totalSum = calculateTotalSalesSum(receipts);
            return totalSum / receipts.length;
        }
    }

}