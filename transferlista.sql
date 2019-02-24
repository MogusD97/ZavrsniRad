drop database if exists transferlista;
create database transferlista character set utf8 collate utf8_general_ci;
# mysql -uedunova -pedunova --default_character_set=utf8 <C:\transferlista.sql
use transferlista;

create table liga(
	sifra 		int not null primary key auto_increment,
	naziv 		varchar(50) not null,
	drzava 		varchar(50) not null
);

create table klub(
	sifra int not null primary key auto_increment,
	naziv varchar (50) not null,
	liga int not null,
	mjesto varchar(50) not null
);

create table igrac(
	sifra int not null primary key auto_increment,
	ime	varchar(50) not null,
	prezime varchar(50) not null,
	klub int not null,
	drzavljanstvo int not null,
	datum_rodenja datetime not null,
	pozicija varchar (50) not null
);

create table drzavljanstvo(
	sifra int not null primary key auto_increment,
	naziv varchar(50) not null,
	nastupa boolean not null
);

create table transferperiod(
	sifra int not null primary key auto_increment,
	naziv varchar(50) not null,
	pocetakperioda datetime not null,
	krajperioda datetime not null
);

create table transferlista(
	sifra int not null primary key auto_increment,
	naziv varchar(50) not null,
	sezona varchar(50) not null,
	transferperiod int not null,
	datum_prelaska datetime not null,
	cijena varchar(50) not null,
	igrac int not null,
	klub_otisao int not null,
	klub_dosao int not null
);

alter table klub add foreign key (liga) references liga(sifra);

alter table igrac add foreign key (klub) references klub(sifra);

alter table igrac add foreign key (drzavljanstvo) references drzavljanstvo(sifra);

alter table transferlista add foreign key (transferperiod) references transferperiod(sifra);

alter table transferlista add foreign key (igrac) references igrac(sifra);

alter table transferlista add foreign key (klub_otisao) references klub(sifra);

alter table transferlista add foreign key (klub_dosao) references klub(sifra);

insert into liga (sifra,naziv,drzava) values
/*1*/(null,'Premier Liga','Engleska'),
/*2*/(null,'Liga 1','Francuska'),
/*3*/(null,'Serie A','Talijanska'),
/*4*/(null,'BundesLiga','Njemačka'),
/*5*/(null,'1. HNL','Hvratska'),
/*6*/(null,'LaLiga','Španjolska');

insert into klub (sifra,naziv,liga,mjesto) values
/*1*/(null,'Manchester City',1,'Engleska'),
/*2*/(null,'Liverpool',1,'Engleska'),
/*3*/(null,'Tottenham Hotspur',1,'Engleska'),
/*4*/(null,'Manchester United',1,'Engleska'),
/*5*/(null,'Arsenal',1,'Engleska'),
/*6*/(null,'Chelsea',1,'Engleska'),
/*7*/(null,'PSG',2,'Francuska'),
/*8*/(null,'Lille',2,'Francuska'),
/*9*/(null,'Olympique Lyonnais',2,'Francuska'),
/*10*/(null,'Olympique Marseille',2,'Francuska'),
/*11*/(null,'Saint-Étienne',2,'Francuska'),
/*12*/(null,'Montpellier',2,'Francuska'),
/*13*/(null,'Juventus',3,'Italija'),
/*14*/(null,'Napoli',3,'Italija'),
/*15*/(null,'Internazionale',3,'Italija'),
/*16*/(null,'Milan',3,'Italija'),
/*17*/(null,'Roma',3,'Italija'),
/*18*/(null,'Borussia Dortmund',4,'Njemačka'),
/*19*/(null,'Bayern München',4,'Njemačka'),
/*20*/(null,'Borussia Mgladbach',4,'Njemačka'),
/*21*/(null,'RB Leipzig',4,'Njemačka'),
/*22*/(null,'Bayer Leverkusen',4,'Njemačka'),
/*23*/(null,'Dinamo Zagreb',5,'Hrvatska'),
/*24*/(null,'Osijek',5,'Hrvatska'),
/*25*/(null,'Rijeka',5,'Hrvatska'),
/*26*/(null,'Lokomotiva Zagreb',5,'Hrvatska'),
/*27*/(null,'Gorica',5,'Hrvatska'),
/*28*/(null,'Hajduk Split',5,'Hrvatska'),
/*29*/(null,'Dinamo Zagreb',5,'Hrvatska'),
/*30*/(null,'Barcelona',6,'Španjolska'),
/*31*/(null,'Atlético Madrid',6,'Španjolska'),
/*32*/(null,'Real Madrid',6,'Španjolska'),
/*33*/(null,'Sevilla',6,'Španjolska'),
/*34*/(null,'Getafe',6,'Španjolska');

insert into drzavljanstvo (sifra,naziv,nastupa) values
/*1*/(null,'Hrvatsko',true),
/*2*/(null,'Hrvatsko',false),
/*3*/(null,'Francusko',true),
/*4*/(null,'Francusko',false),
/*5*/(null,'Njemačko',true),
/*6*/(null,'Njemačko',false),
/*7*/(null,'Talijansko',true),
/*8*/(null,'Talijansko',false),
/*9*/(null,'Španjolsko',true),
/*10*/(null,'Španjolsko',false),
/*11*/(null,'Argentinsko',true),
/*12*/(null,'Argentinsko',false),
/*13*/(null,'Brazilsko',true),
/*14*/(null,'Brazilsko',false),
/*15*/(null,'Egipatsko',true),
/*16*/(null,'Egipatsko',false),
/*17*/(null,'Dansko',true),
/*18*/(null,'Dansko',false),
/*19*/(null,'Kolumbijsko',true),
/*20*/(null,'Kolumbijsko',false),
/*21*/(null,'Welško',true),
/*22*/(null,'Welško',false),
/*23*/(null,'Belgijsko',true),
/*24*/(null,'Belgijsko',false);



insert into igrac (sifra,ime,prezime,klub,drzavljanstvo,datum_rodenja,pozicija) values
/*1*/(null,'Sergio','Aguero',1,11,'1988-06-02','napadač'),
/*2*/(null,'Ederson','Moraes',1,13,'1993-08-17','golman'),
/*3*/(null,'Dejan','Lovren',2,1,'1989-07-05','branič'),
/*4*/(null,'Mohamed','Salah',2,15,'1992-06-15','krilo'),
/*5*/(null,'Christian','Eriksen',3,17,'1992-02-14','vezni'),
/*6*/(null,'Davinson','Sanchez',3,19,'1996-06-16','branič'),
/*7*/(null,'Paul','Pogba',4,3,'1993-03-15','vezni'),
/*8*/(null,'David','de Gea',4,9,'1990-11-07','golman'),
/*9*/(null,'Aaron','Ramesy',5,21,'1990-12-26','vezni'),
/*10*/(null,'Alexandre','Lacazette',5,3,'1990-11-07','golman'),
/*11*/(null,'Willian','Borges da Silva',6,13,'1988-08-09','krilo'),
/*12*/(null,'Edin','Hazarad',6,23,'1991-01-07','veznjak,krilo'),
/*13*/(null,'Josip','Špoljarić',24,1,'1997-01-05','veznjak'),
/*14*/(null,'Mile','Škorić',24,2,'1991-06-19','krilni napadač'),
/*15*/(null,'Lionel','Messi',30,11,'1987-06-24','krilni napadač'),
/*16*/(null,'Gerard','Pique',30,9,'1987-02-02','branič'),
/*17*/(null,'Luka','Modrić',32,1,'1985-09-09','veznjak'),
/*18*/(null,'Raphael','Varane',32,3,'1993-04-25','branič');





