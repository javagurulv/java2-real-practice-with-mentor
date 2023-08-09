package org.javaguru.applewarehouse;

class GreenAppleSearchCriteria implements AppleSearchCriteria {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
