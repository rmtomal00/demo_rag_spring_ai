# demo_rag_spring_ai

Spring AI + Qdrant demo project built with Spring Boot.

## Overview

This repository demonstrates a Retrieval-Augmented Generation (RAG) setup using:

- **Spring Boot**
- **Spring AI**
- **Qdrant** (vector database)
- **Ollama** and/or **OpenAI** model integrations

It appears to be an early-stage demo scaffold for experimenting with LLM-backed retrieval workflows in a Java/Spring ecosystem.

## Tech Stack

- Java **25**
- Spring Boot **4.1.0**
- Spring AI **2.0.0**
- Maven wrapper (`mvnw`, `mvnw.cmd`)

## Dependencies (from `pom.xml`)

Key dependencies included:

- `spring-boot-starter-webmvc`
- `spring-ai-starter-model-ollama`
- `spring-ai-starter-vector-store-qdrant`
- `spring-ai-vector-store-advisor`
- `spring-ai-starter-model-openai`
- Lombok
- `spring-boot-starter-webmvc-test` (test scope)

## Project Structure

Current top-level layout:

- `pom.xml` – Maven + dependency management
- `src/main` – application source code
- `src/test` – tests
- `HELP.md` – generated Spring starter help/reference
- `mvnw`, `mvnw.cmd` – Maven wrapper scripts

## Prerequisites

Before running locally, make sure you have:

- JDK **25**
- Docker (recommended, for running Qdrant and optionally Ollama)
- Internet access / API credentials if using OpenAI
- Maven is optional (wrapper included)

## Configuration

Create an `application.yml` or `application.properties` under:

`src/main/resources/`

You’ll typically configure:

- Spring app settings
- Qdrant connection (host/port/collection)
- Model provider configuration:
  - Ollama (local endpoint + model)
  - and/or OpenAI (API key + model)

> Note: Exact property names depend on the Spring AI version you use.  
> Check Spring AI docs for the precise keys:
> - Ollama: https://docs.spring.io/spring-ai/reference/api/chat/ollama-chat.html
> - Qdrant: https://docs.spring.io/spring-ai/reference/api/vectordbs/qdrant.html

## Running the App

### Linux/macOS

```bash
./mvnw spring-boot:run
```

### Windows

```powershell
mvnw.cmd spring-boot:run
```

## Build

```bash
./mvnw clean package
```

## Test

```bash
./mvnw test
```

## Notes

- This repo currently looks like a starter/demo baseline.
- If you plan to publish/share broadly, consider adding:
  - architecture diagram
  - sample documents for ingestion
  - example API requests/responses
  - Docker Compose for Qdrant/Ollama
  - environment variable template (`.env.example`)

## Useful References

- Spring AI Reference: https://docs.spring.io/spring-ai/reference/
- Spring Boot Maven Plugin: https://docs.spring.io/spring-boot/4.1.0/maven-plugin
- Qdrant Docs: https://qdrant.tech/documentation/
- Ollama: https://ollama.com/
