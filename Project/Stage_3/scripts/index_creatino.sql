CREATE INDEX "ДАТА_СМЕРТИ" ON "death_data" USING BTREE("date_of_death");
CREATE INDEX "ФАМИЛИЯ_ЧЕЛОВЕКА" ON "personal_data" USING HASH("second_name");
CREATE INDEX "ФАМИЛИЯ_РАБОТНИКА" ON "worker" USING HASH("second_name");
CREATE INDEX "ДАТА_ВЫДАЧИ" ON "body_reciving" USING BTREE("receiving_date");
CREATE INDEX "ИМЯ_ОТВЕТСТВЕННОГО" ON "case_info" USING HASH("responsible_person_name");