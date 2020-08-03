INSERT INTO `seveneleven`.`role` (`ro_id`, `ro_role`) VALUES ('1', 'admin');
INSERT INTO `seveneleven`.`role` (`ro_id`, `ro_role`) VALUES ('2', 'user');


INSERT INTO `seveneleven`.`user` (`us_id`, `us_name`, `us_password`, `ro_id`) VALUES ('1', 'admin', '$2a$10$cor7vC0djBiBfNQ9ffr6.e/eMycKoX7iQD6Lwuwnr7Y4Wxcwi9GYe', '1');
INSERT INTO `seveneleven`.`user` (`us_id`, `us_name`, `us_password`, `ro_id`) VALUES ('2', 'user', '$2a$10$cor7vC0djBiBfNQ9ffr6.e/eMycKoX7iQD6Lwuwnr7Y4Wxcwi9GYe', '2');


INSERT INTO `seveneleven`.`employee` (`emp_id`, `emp_domain`, `emp_designation`, `emp_name`, `emp_salary`) VALUES ('1', 'Healthcare', 'Trainee', 'Ram', '27000');
INSERT INTO `seveneleven`.`employee` (`emp_id`, `emp_domain`, `emp_designation`, `emp_name`, `emp_salary`) VALUES ('2', 'Insurance', 'Analyst', 'Dhanush', '30000');
INSERT INTO `seveneleven`.`employee` (`emp_id`, `emp_domain`, `emp_designation`, `emp_name`, `emp_salary`) VALUES ('3', 'Retail', 'Associatte', 'Dinesh', '45000');
INSERT INTO `seveneleven`.`employee` (`emp_id`, `emp_domain`, `emp_designation`, `emp_name`, `emp_salary`) VALUES ('4', 'Healthcare', 'Analyst', 'Rajesh', '35000');
INSERT INTO `seveneleven`.`employee` (`emp_id`, `emp_domain`, `emp_designation`, `emp_name`, `emp_salary`) VALUES ('5', 'Insurance', 'Adsociate', 'Sundar', '40000');
