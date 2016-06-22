insert into oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, authorities)
  values ('my-client', 'api-res', 'my-secret', 'read', 'password', 'ROLE_CLIENT');

insert into oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, authorities)
  values ('my-client-with-credentials', 'api-res', 'secret', 'read,write', 'client_credentials', 'ROLE_CLIENT');

insert into oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, authorities)
  values ('my-trusted-client', 'api-res', 'secret', 'read,write,trust', 'client_credentials,password,authorization_code,refresh_token,implicit', 'ROLE_CLIENT,ROLE_TRUSTED_CLIENT');


insert into users (username, password, enabled) values ('ali', 'pwd', true);
insert into users (username, password, enabled) values ('vali', 'pwd1', true);

insert into authorities (username, authority) values ('ali', 'ROLE_USER,ROLE_ADMIN,ROLE_DBA');
insert into authorities (username, authority) values ('vali', 'ROLE_USER');