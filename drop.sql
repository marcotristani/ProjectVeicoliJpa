
    set client_min_messages = WARNING;

    alter table if exists bici 
       drop constraint if exists FK12eouncnc1ktk0429ws8ym1y9;

    alter table if exists bici 
       drop constraint if exists FK6u5vomfhxpd4jeflurf287pti;

    alter table if exists bici 
       drop constraint if exists FK8ma46gvl87a152woxxd940bc2;

    alter table if exists macchine 
       drop constraint if exists FK7gued6f7mmdwo1cbddtpkdvlp;

    alter table if exists moto 
       drop constraint if exists FK893boxjxrhxuyuqr3is7jb9lc;

    alter table if exists veicoli 
       drop constraint if exists FKqiaa60l6pjj6t6ymcvliv3a5f;

    alter table if exists veicoli 
       drop constraint if exists FK6ts9tnk9ryucc21iobqw34ell;

    alter table if exists veicoli 
       drop constraint if exists FKbb5qm9kqwit9ofmcpy5yol65k;

    alter table if exists veicoli 
       drop constraint if exists FKlb3iq537awslofdbv2r5m5rq4;

    alter table if exists veicoli 
       drop constraint if exists FKsnerid94jcoa9e9dn1ar8blau;

    drop table if exists alimentazioni cascade;

    drop table if exists bici cascade;

    drop table if exists categorie cascade;

    drop table if exists colori cascade;

    drop table if exists freni cascade;

    drop table if exists full_veicolo cascade;

    drop table if exists macchine cascade;

    drop table if exists marche cascade;

    drop table if exists moto cascade;

    drop table if exists tipo_sospensioni cascade;

    drop table if exists tipo_veicoli cascade;

    drop table if exists veicoli cascade;
