How to test
-----

 - Grant Type by `password`:
    `curl client:secret@localhost:8080/oauth/token -d grant_type=password -d username=user -d password=pwd -d scope=read`
    `curl -H "Authorization: Bearer $SomeToken" http://localhost:8080/me`

 - Grant type by `client crendentials`:
    `curl client:secret@localhost:8080/oauth/token -d grant_type=client_credentials -d scope=read`
    `curl -H "Authorization: Bearer $SomeToken" http://localhost:8080/me`
