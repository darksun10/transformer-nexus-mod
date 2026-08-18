#!/usr/bin/env bash
set -euo pipefail

if command -v mvn >/dev/null 2>&1; then
  mvn clean package
else
  echo "Maven is not installed. Install Maven, then run: mvn clean package"
  exit 1
fi
