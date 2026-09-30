#!/bin/bash
# EC2(msa-app)에서 실행하는 배포 스크립트.
# GitHub Actions(.github/workflows/deploy.yml)가 SSH로 접속해 이 파일을 실행한다.
#
# 사용법
#   ./deploy.sh                      전체 서비스 갱신
#   ./deploy.sh board-service        지정한 서비스만 갱신
set -e
cd "$(dirname "$0")"

COMPOSE="docker compose -f docker-compose.aws.yml"
# ${*:-...} : 인자를 안 주면 기본값(전체 서비스)을 쓴다
SERVICES="${*:-config-service auth-service board-service edge-service web-service}"

echo "[1/4] 최신 코드 받기"
# --ff-only : 서버에서 코드를 고쳐서 GitHub과 갈라졌으면 병합하지 말고 실패시킨다
git pull --ff-only

echo "[2/4] 이미지 빌드 (메모리 때문에 하나씩)"
for s in $SERVICES; do
  echo "  - $s"
  $COMPOSE build "$s"
done

echo "[3/4] 컨테이너 교체"
$COMPOSE up -d $SERVICES

echo "[4/4] 이전 이미지 정리"
# 태그 없는(dangling) 옛 이미지 삭제. 안 하면 디스크가 금방 찬다.
docker image prune -f

echo
$COMPOSE ps
