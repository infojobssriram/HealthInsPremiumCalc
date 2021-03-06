create database hipremiumcalc;
use hipremiumcalc;
CREATE TABLE premium_details(
  ID INT(3) NOT NULL,
  BASE_PREMIUM  DOUBLE PRECISION(7,2),
  CONSTRAINT PREMIUM_DTLS_PK PRIMARY KEY (ID)
);

CREATE TABLE premium_calc_criteria(
  CRITERIA_NAME VARCHAR(50),
  IS_ACTIVE INT(1) DEFAULT 1,
  CONSTRAINT PREMIUM_CALC_CRITERIA_PK PRIMARY KEY (CRITERIA_NAME)
);

CREATE TABLE age_criteria_details(
  ID INT(20) NOT NULL AUTO_INCREMENT,
  START_AGE INT(3),
  END_AGE INT(3),
  VARIANCE_PERCT INT(3),
  CONSTRAINT AGE_CRITERIA_DETAILS_ID_PK PRIMARY KEY (ID)
);

CREATE TABLE gender_criteria_details(
  GENDER VARCHAR(10),
  VARIANCE_PERCT INT(3),
  CONSTRAINT GENDER_CRITERIA_DETAILS_PK PRIMARY KEY (GENDER)
);

CREATE TABLE habits_criteria_details(
  HABIT VARCHAR(20),
  VARIANCE_PERCT INT(3),
  CONSTRAINT HABITS_CRITERIA_DETAILS_PK PRIMARY KEY (HABIT)
);
             
CREATE TABLE preexisting_health_criteria_details(
  HEALTHCOND VARCHAR(20),
  VARIANCE_PERCT INT(3),
  CONSTRAINT HABITS_CRITERIA_DETAILS_PK PRIMARY KEY (HEALTHCOND)
);