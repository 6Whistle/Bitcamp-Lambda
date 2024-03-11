package com.erichgamma.api.common;

public interface UtilService {
    int createRandomInt(int begin, int range);
    double createRandomDouble(double begin, double range);

    String createRandomName();

    String createRandomUsername();

    String createRandomTitle();

    String createRandomContent();

    String createRandomCompany();

    String createRandomJob();
}
