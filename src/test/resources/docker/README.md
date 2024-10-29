# Docker
[Docker](https://www.docker.com/)
## Docker commands
| Command Name                       | Command                            |
|------------------------------------|------------------------------------|
| Start Services                     | `docker-compose up`                |
| Run Services in Detached Mode      | `docker-compose up -d  `           |
| Stop Services                      | `docker compose down   `           |
| Access MySQL in a Docker Container | `docker exec -it <container-name>` |
| Identifying Dangling Images        | `docker images -f "dangling=true"` |
| Removing Dangling Images           | `docker image prune`               |
| List Running Containers            | `docker ps`                        |
| Connect to the Jenkins Container   | `docker exec -it jenkins bash`     |
| Exit the Container                 | `exit`                             |