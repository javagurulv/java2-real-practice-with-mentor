package org.javaguru.mentor.lesson_11.lessoncode;

import java.math.BigDecimal;
import java.util.List;

public class PremiumCalculator {

    public BigDecimal calculate(Policy policy) {
        BigDecimal premium = BigDecimal.ZERO;

        //1. calculate PREMIUM_FIRE
        // 1.1. calculate SUM_INSURED_FIRE -
        // sum of all subObject sums what insured from FIRE
        // 1.2. choice COEFFICIENT_FIRE (0.014 or 0.024)
        // 1.3. PREMIUM_FIRE = SUM_INSURED_FIRE * COEFFICIENT_FIRE

        //2. calculate PREMIUM_THEFT
        // 2.1. calculate SUM_INSURED_THEFT -
        // sum of all subObject sums what insured from THEFT
        // 2.2. choice COEFFICIENT_FIRE (0.11 or 0.05)
        // 2.3. PREMIUM_THEFT = SUM_INSURED_THEFT * COEFFICIENT_THEFT

        //3.  premium for one object = PREMIUM_FIRE + PREMIUM_THEFT

        //4. sum all object premiums
        for (InsuredObject object : policy.getObjects()) {
            BigDecimal premiumFire = calculatePremiumFire(object);
            BigDecimal premiumTheft = calculatePremiumFire(object);
            premium = premium.add(premiumFire).add(premiumTheft);
        }

        return premium;
    }

    private BigDecimal calculatePremiumFire(InsuredObject object) {
        // 1.1. calculate SUM_INSURED_FIRE -
        // sum of all subObject sums what insured from FIRE
        BigDecimal sumInsuredFire = BigDecimal.ZERO;
        for (InsuredSubObject subObject : object.getSubObjects()) {
            List<RiskType> subObjectRisks = subObject.getRisks();
            if (subObjectRisks.contains(RiskType.FIRE)) {
                sumInsuredFire = sumInsuredFire.add(subObject.getSum());
            }
        }

        // 1.2. choice COEFFICIENT_FIRE (0.014 or 0.024)
        BigDecimal coefficientFire = new BigDecimal("0.014");
        BigDecimal oneHundred = new BigDecimal("100");
        if (sumInsuredFire.compareTo(oneHundred) > 0) {
            coefficientFire = new BigDecimal("0.024");
        }

        // 1.3. PREMIUM_FIRE = SUM_INSURED_FIRE * COEFFICIENT_FIRE
        return sumInsuredFire.multiply(coefficientFire);
    }


}
