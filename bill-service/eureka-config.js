const Eureka = require('eureka-js-client').Eureka;

const client = new Eureka({
    instance: {
        app: 'Bill-microservice',
        hostName: 'localhost', // Replace with your server's hostname
        ipAddr: '127.0.0.1',   // Replace with your server's IP address
        port: {
            '$': 2000,           // Your service's port
            '@enabled': true,
        },
        vipAddress: 'Bill-microservice',
        dataCenterInfo: {
            '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
            name: 'MyOwn',
        },
    },
    eureka: {
        host: 'localhost', // Eureka server's hostname
        port: 8761,                // Eureka server's port
        servicePath: '/eureka/apps/',
    },
});

client.logger.level('debug'); // Optional: Set logging level

// Register with Eureka
client.start((error) => {
    if (error) {
        console.log(error);
    } else {
        console.log('Eureka registration complete');
    }
});

module.exports = {
    client, // Export the client object
};