```sql
create table modeadministration(
    id int not null primary key AUTO_INCREMENT,
    descriptionmode varchar(60) not null
);

drop table modeadiministration;
create table activeprinciple(
    idap int not null primary key AUTO_INCREMENT,
    nameap varchar(60) not null
);
create table unitmeasurement(
    idum int not null primary key AUTO_INCREMENT,
    nameum varchar(50)
);
create table country(
    codecountry varchar(5) not null primary key,
    namecountry varchar(50) not null
);
create table region(
    codereg varchar(5) not null primary key,
    namereg varchar(50) not null,
    codecountry varchar(5) not null,
    Foreign Key (codecountry) REFERENCES country(codecountry)
);
create table city(
    codecity varchar(5) not null primary key,
    namecity varchar(50) not null,
    codereg varchar(5) not null,
    Foreign Key (codereg) REFERENCES region(codereg)
);
create table customer(
    idcustomer varchar(20) not null primary key,
    namecustomer varchar(50) not null,
    lastnamecustomer varchar(50) not null,
    emailcustomer varchar(100) not null,
    birthdate date not null,
    lon float(8),
    latidud float(8),
    codecitycustomer varchar(5) not null,
    Foreign Key (codecitycustomer) REFERENCES city(codecity)
);
create table laboratory(
    id int not null primary key AUTO_INCREMENT,
    namelab varchar(50) not null,
    codecityreg varchar(5) not null,
    Foreign Key (codecityreg) REFERENCES city(codecity)
);
create table medicine(
    id int not null PRIMARY KEY AUTO_INCREMENT,
    proceedings varchar(10) not null,
    namemedicine varchar(100) not null,
    healthregister varchar(50) not null,
    description text not null,
    descriptionshort varchar(60) not null,
    namerol varchar(100) not null,
    codemodeadmin int not null,
    codeap int not null,
    codeum int not null,
    codelab int not null,
    Foreign Key (codemodeadmin) REFERENCES modeadministration(id),
    Foreign Key (codeap) REFERENCES activeprinciple(idap),
    Foreign Key (codeum) REFERENCES unitmeasurement(idum),
    Foreign Key (codelab) REFERENCES laboratory(id)
);
create table pharmacy(
    idpharmacy int not null PRIMARY KEY AUTO_INCREMENT,
    namepharmacy varchar(60) not null,
    addresspharmacy varchar(100) not null,
    iong float(8) not null,
    latpharmacy float(8) not null,
    logopharmacy varchar(50) not null,
    codecitypharm varchar(5) not null,
    Foreign Key (codecitypharm) REFERENCES city(codecity)
);
create table pharmacymedicine(
    idpharmacy int not null,
    idmedicine int not null,
    price float(8) not null,
    primary key(idpharmacy, idmedicine),
    Foreign Key (idpharmacy) REFERENCES pharmacy(idpharmacy),
    Foreign Key (idmedicine) REFERENCES medicine(id)
);
```