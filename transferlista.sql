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