package org.javaguru.mentor.lesson_11.lessoncode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PolicyCreatorExample {

    public static void main(String[] args) {
        InsuredSubObject tv = new InsuredSubObject(
                "TV",
                new BigDecimal("1000.50"),
                List.of(RiskType.FIRE)
        );
        InsuredSubObject fridge = new InsuredSubObject(
                "FRIDGE",
                new BigDecimal("500.00"),
                List.of(RiskType.FIRE, RiskType.THEFT)
        );

        List<InsuredSubObject> subObjects = new ArrayList<>();
        subObjects.add(tv);
        subObjects.add(fridge);

        InsuredObject object1 = new InsuredObject(
                "House 1",
                subObjects
        );
        List<InsuredObject> objects = new ArrayList<>();
        objects.add(object1);

        Policy policy = new Policy(
                "LV-1",
                PolicyStatus.REGISTERED,
                objects
        );

        System.out.println("sdsdfds");


    }

}
