all: build

build:
	@./gradlew build --warning-mode all

test:
	@./gradlew test --warning-mode all

run:
	@./gradlew run

clean:
	@./gradlew clean

container-boot:
	@docker-compose up -d

container-test:
	@docker exec rock.paper.scissors ./gradlew test --warning-mode all

container-stop:
	@docker-compose down