#!/bin/sh

docker build -t cestao_backend .
docker run --network cestao -p 8080:8080 -d --name cestao_backend cestao_backend