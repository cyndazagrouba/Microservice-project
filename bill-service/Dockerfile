
# Use the official Node.js image
FROM node:latest

# Set the working directory
WORKDIR /usr/src/app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the app's source code
COPY . .


# Copy the 'eureka-config' file from the root directory to the root directory of the Docker image
COPY eureka-config.js /usr/src/app/


# Expose the port the app runs on
EXPOSE 2000

# Command to run the app
CMD [ "node", "app.js" ]
