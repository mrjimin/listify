#!/bin/bash
set -euo pipefail

# ----------------------
# Load local environment variables
# ----------------------
set -a
source .env
set +a

# ----------------------
# Step 1: Build Spring Boot JAR
# ----------------------
echo "🧹 Building Spring Boot JAR..."
./gradlew clean bootJar

# ----------------------
# Step 2: Build & Push Docker Image
# ----------------------
echo "🐳 Building & Pushing Docker Image..."
docker buildx build \
  --platform linux/amd64 \
  -t "$DOCKER_IMAGE:$DOCKER_TAG" \
  --push .

# ----------------------
# Step 3: SSH to server & deploy (optimized)
# ----------------------
echo "🚀 Deploying to Server..."
ssh -p "$SSH_PORT" "$SSH_USER@$SSH_HOST" \
"cd '$DOCKER_COMPOSE_PATH' && \
 echo '⬇ Pulling latest Docker image...' && \
 docker compose pull && \
 echo '🔄 Restarting containers...' && \
 docker compose up -d --remove-orphans && \
 echo '✅ Deployment Complete!'"

echo "🎉 All steps finished successfully!"