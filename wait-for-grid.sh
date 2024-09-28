#!/bin/bash

# Wait until Selenium Grid is ready
while ! curl -s http://localhost:4444/wd/hub/status | grep -q "\"ready\":true"; do
  echo "Waiting for Selenium Grid..."
  sleep 2
done

echo "Selenium Grid is ready!"
