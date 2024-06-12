.PHONY: clean build run

clean:
    mvn clean

build:
    mvn clean install

run:
    docker-compose up --build
