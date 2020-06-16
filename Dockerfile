FROM java:8-jdk-alpine
VOLUME /tmp

ARG JAR_FILE

ARG DEPENDENCY=build/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

EXPOSE 9090

HEALTHCHECK --start-period=60s --interval=5s --timeout=3s CMD wget -q http://localhost:9090/actuator/health -0 /tmp.app-health || exit 1

ENTRYPOINT ["java","-cp", "app:app/lib/*","com.nab.finance.TicTacToeApplication"]

USER nobody