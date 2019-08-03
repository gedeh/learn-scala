# Learning Scala

Attempt to learn Scala by creating a simple HTTP Web API

## Install

- Install **Scoop** using PowerShell
```powershell
Set-ExecutionPolicy RemoteSigned -scope CurrentUser
iex (new-object net.webclient).downloadstring('https://get.scoop.sh')
```
- Install **Java**
```
scoop bucket add java
scoop install oraclejdk-lts
```
- Install **Scala** using `scoop install scala`
- Install **SBT** using `scoop install sbt`

## Run

- Use `sbt run -http.port=:8080 -admin.port=:8090` to run the HTTP server
- Open URL `http://localhost:8080/hello` in browser
- Open URL `http://localhost:8090/admin` in browser for Admin UI