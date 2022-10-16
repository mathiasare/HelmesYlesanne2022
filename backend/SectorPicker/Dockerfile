FROM eclipse-temurin:17-alpine

VOLUME /tmp
WORKDIR /app

COPY ./build/dependency/BOOT-INF/lib ./lib
COPY ./build/dependency/BOOT-INF/classes ./classes
COPY ./build/dependency/META-INF ./classes/META-INF

ENTRYPOINT exec java $JAVA_OPTS -cp ./classes:./lib/* ee.mathias.are.helmes.exercise.sectorpicker.SectorPickerApplication
