all: build

build:
	@./gradlew build --warning-mode all

tests:
	@./gradlew test --warning-mode all