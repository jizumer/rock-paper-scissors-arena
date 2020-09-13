all: build

build:
	@./gradlew build --warning-mode all

test:
	@./gradlew test --warning-mode all

run-backend:
	@./gradlew run --args=backend

run-frontend:
	@./gradlew run --args=frontend

clean:
	@./gradlew clean

container-boot:
	@docker-compose -f docker-compose.yml up -d --remove-orphans --build

container-stop:
	@docker-compose down
	@docker rmi --force rock.paper.scissors:develop

container-test:
	@./gradlew build --warning-mode all
	@docker-compose -f docker-compose-test.yml up -d --remove-orphans  --build
	@docker exec -w /app rock.paper.scissors ./gradlew test --warning-mode all
	@docker-compose down
	@docker rmi --force rock.paper.scissors:develop
