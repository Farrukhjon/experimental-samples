Authentication, OAuth2 Authorization and Resource Servers in one.
---------------

By client credentials: curl my-trusted-client:secret@localhost:8080/oauth/token -d grant_type=client_credentials -d scope=read
By password: curl my-trusted-client:secret@localhost:8080/oauth/token -d grant_type=password -d username=ali -d password=pwd -d scope=read
