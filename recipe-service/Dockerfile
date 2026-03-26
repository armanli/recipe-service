FROM maven:3-eclipse-temurin-21-alpine AS maven-builder
WORKDIR /build
COPY pom.xml .
COPY src/ src/
RUN --mount=type=cache,target=/root/.m2 \
  mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-alpine AS jar-extractor
WORKDIR /application
COPY --from=maven-builder /build/target/*.jar application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM eclipse-temurin:21-jre-alpine
WORKDIR /application

COPY --from=jar-extractor /application/dependencies/ ./
COPY --from=jar-extractor /application/spring-boot-loader/ ./
COPY --from=jar-extractor /application/snapshot-dependencies/ ./
COPY --from=jar-extractor /application/application/ ./
COPY --from=jar-extractor /application/application.jar ./application.jar

RUN cat <<'EOF' | tr -d '\r' > /application/entrypoint.sh
#!/bin/sh
if [ ! -f /application/application.jsa ]; then
    echo "🚀 Gerando archive CDS..."
    java -XX:ArchiveClassesAtExit=/application/application.jsa \
         -Dspring.context.exit=onRefresh \
         -Dspring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration,org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration,org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration \
         -jar /application/application.jar || echo "⚠️ Falha no CDS, continuando..."
fi

echo "✅ Iniciando aplicação com AppCDS..."
exec java -XX:SharedArchiveFile=/application/application.jsa -Xms128m -Xmx512m -jar /application/application.jar
EOF

RUN chmod +x /application/entrypoint.sh

EXPOSE 8080

ENTRYPOINT ["sh", "/application/entrypoint.sh"]