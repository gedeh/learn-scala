# Learning Scala

Attempt to learn Scala by creating a simple HTTP Web API

## Install

Install `scoop` using PowerShell
```powershell
Set-ExecutionPolicy RemoteSigned -scope CurrentUser
iex (new-object net.webclient).downloadstring('https://get.scoop.sh')
```
Install `jdk8`
```
scoop bucket add java
scoop install oraclejdk-lts
```
Install `scala` using `scoop install scala`
Install `sbt` using `scoop install sbt`

## Run

- Run `sbt run -http.port=:8080 -admin.port=:8090`
- Open URL `http://localhost:8080/hello` in browser
- Open URL `http://localhost:8090/admin` in browser for Admin UI