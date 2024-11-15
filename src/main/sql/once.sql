drop user if exists cfs1;
drop schema if exists cfs1;

create user cfs1 identified by 'password';
create schema cfs1;

grant all privileges on cfs1.* to cfs1;
