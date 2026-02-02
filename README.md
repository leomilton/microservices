# Microservices Notification System

This project demonstrates a simple **microservices-based notification system**
using **Spring Boot**, **RabbitMQ**, and **Docker Compose**.

---

## System Components

- **micro-sender**
    - REST API to send notifications
    - Publishes messages to RabbitMQ

- **micro-recipient**
    - Consumes messages from RabbitMQ
    - Stores messages in memory
    - Scheduler logs message count every N seconds
    - REST API returns and clears messages

- **micro-collector**
    - Periodically calls micro-recipient REST API
    - Logs collected messages every M seconds (M > N)

- **RabbitMQ**
    - Message broker between sender and recipient

---

# RabbitMQ (Standalone Docker Commands)

## 1 Run RabbitMQ Container

``` bash
docker run -d \
  --name rabbitmq \
  -p 5672:5672 \
  -p 15672:15672 \
  rabbitmq:3-management
```
## 2 Start Existing RabbitMQ Container

```bash
docker start rabbitmq
```

## 3 Stop Existing RabbitMQ Container

```bash
docker stop rabbitmq
```

## 4 RabbitMQ Management Console
```
URL: http://localhost:15672
Username: guest
Password: guest

Ports Used
5672 → AMQP (used by microservices)
15672 → RabbitMQ Management UI
```
---

## Docker Compose Commands

All services (RabbitMQ + microservices) can be managed together using
docker-compose.yml.

⚠ Make sure JAR files are built before running Docker Compose:

./gradlew build

## 1 Build Images & Start Containers

```
docker-compose up --build
```
This command:
Builds Docker images for all microservices
Creates Docker networks
Starts all containers
Shows logs in the terminal

## 2 Start Containers in Detached Mode
```
docker-compose up --build -d
```
Runs containers in the background.

## 3 Stop and Remove Containers
```
docker-compose down
```
Stops and removes:
Containers
Networks created by docker-compose
