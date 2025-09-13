# =====================================
# ビルドステージ
# =====================================
FROM eclipse-temurin:21-jdk as builder

WORKDIR /app

# Gradleファイルをコピー
COPY gradlew .
COPY gradle gradle/
COPY build.gradle .
COPY settings.gradle .

# 依存関係をダウンロード
RUN ./gradlew dependencies --no-daemon

# ソースコードをコピー
COPY src src

# アプリケーションをビルド（backend-0.0.1-SNAPSHOT.jarを生成）
RUN ./gradlew bootJar --no-daemon

# =====================================
# 実行ステージ
# =====================================
FROM eclipse-temurin:21-jre

WORKDIR /app

# ビルドステージからJARファイルをコピー（元の命名に合わせる）
COPY --from=builder /app/build/libs/backend-0.0.1-SNAPSHOT.jar /app/react-spring-playground.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/react-spring-playground.jar"]