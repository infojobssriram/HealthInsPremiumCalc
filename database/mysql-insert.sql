insert into premium_details values(1,5000);

insert into premium_calc_criteria values('age',1);
insert into premium_calc_criteria values('gender',1);
insert into premium_calc_criteria values('preexistinghealth',1);
insert into premium_calc_criteria values('habit',1);


insert into age_criteria_details values(1,0,18,0);
insert into age_criteria_details values(2,19,25,10);
insert into age_criteria_details values(3,25,30,10);
insert into age_criteria_details values(4,30,35,10);
insert into age_criteria_details values(5,35,40,10);
insert into age_criteria_details values(6,40,45,5);
insert into age_criteria_details values(7,45,50,5);
insert into age_criteria_details values(8,50,55,5);
insert into age_criteria_details values(9,55,60,5);
insert into age_criteria_details values(10,60,65,5);
insert into age_criteria_details values(11,65,70,5);
insert into age_criteria_details values(12,70,75,5);
insert into age_criteria_details values(13,75,80,5);
insert into age_criteria_details values(14,80,85,5);
insert into age_criteria_details values(15,90,95,5);
insert into age_criteria_details values(16,95,100,5);

insert into gender_criteria_details values('male',2);
insert into gender_criteria_details values('female',0);


insert into habits_criteria_details values('dailyexcercise',-3);
insert into habits_criteria_details values('smoking',3);
insert into habits_criteria_details values('alcohol',3);
insert into habits_criteria_details values('drugs',3);


insert into preexisting_health_criteria_details values('hypertension ',1);
insert into preexisting_health_criteria_details values('blookpressure ',1);
insert into preexisting_health_criteria_details values('diabetes',1);
insert into preexisting_health_criteria_details values('overweight',1);
