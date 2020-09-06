all: build

build:
	@./gradlew build --warning-mode all

test:
	@./gradlew test --warning-mode all

boot:
	@docker-compose up -d

container-test:
	@docker exec rock.paper.scissors ./gradlew test --warning-mode all