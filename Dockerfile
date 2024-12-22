# Use an official Java runtime as a base image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file and any other necessary files into the container
COPY target/springboot-aws-ecs-dockerizing-0.0.1-SNAPSHOT.jar /app

# Expose the application port (replace 8080 with your app's port)
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "springboot-aws-ecs-dockerizing-0.0.1-SNAPSHOT.jar"]
