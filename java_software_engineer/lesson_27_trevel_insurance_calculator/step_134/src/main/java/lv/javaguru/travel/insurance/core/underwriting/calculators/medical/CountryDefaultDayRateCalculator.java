package lv.javaguru.travel.insurance.core.underwriting.calculators.medical;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.domain.TravelMedicalCountryDefaultDayRate;
import lv.javaguru.travel.insurance.core.repositories.TravelMedicalCountryDefaultDayRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
class CountryDefaultDayRateCalculator {

    @Autowired private TravelMedicalCountryDefaultDayRateRepository travelMedicalCountryDefaultDayRateRepository;

    BigDecimal calculate(AgreementDTO agreement) {
        return travelMedicalCountryDefaultDayRateRepository.findByCountryIc(agreement.getCountry())
                .map(TravelMedicalCountryDefaultDayRate::getDefaultDayRate)
                .orElseThrow(() -> new RuntimeException("Country day rate not found by country id = " + agreement.getCountry()));
    }

}
