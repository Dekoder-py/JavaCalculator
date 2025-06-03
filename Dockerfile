# ---------- Stage 1: Build & create JDK ----------
FROM openjdk:21-slim AS build

# Install git and jlink dependencies
RUN apt-get update && apt-get install -y git && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# Clone your repo
RUN git clone https://github.com/Dekoder-py/JavaCalculator.git

# Create a minimal JRE using jlink
RUN jlink \
  --module-path "$JAVA_HOME/jmods" \
  --add-modules java.base \
  --output /opt/jdk

# Compile Java source
WORKDIR /app/JavaCalculator
RUN mkdir -p /out && javac -d /out src/Main.java

# ---------- Stage 2: Runtime ----------
FROM debian:bookworm-slim

COPY --from=build /opt/jdk /opt/jdk
COPY --from=build /out /out


ENV JAVA_HOME=/opt/jdk
ENV PATH="$JAVA_HOME/bin:$PATH"

CMD ["java", "-cp", "/out", "Main"]

