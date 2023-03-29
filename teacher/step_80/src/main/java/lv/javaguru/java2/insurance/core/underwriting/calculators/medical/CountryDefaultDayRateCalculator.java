package lv.javaguru.java2.insurance.core.underwriting.calculators.medical;

import lv.javaguru.java2.insurance.core.domain.CountryDefaultDayRate;
import lv.javaguru.java2.insurance.core.repositories.CountryDefaultDayRateRepository;
import lv.javaguru.java2.insurance.dto.TravelCalculatePremiumRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
class CountryDefaultDayRateCalculator {

    @Autowired private CountryDefaultDayRateRepository countryDefaultDayRateRepository;

    BigDecimal calculate(TravelCalculatePremiumRequest request) {
        return countryDefaultDayRateRepository.findByCountryIc(request.getCountry())
                .map(CountryDefaultDayRate::getDefaultDayRate)
                .orElseThrow(() -> new RuntimeException("Country day rate not found by country id = " + request.getCountry()));
    }

}
