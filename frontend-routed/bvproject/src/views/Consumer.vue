<template>
  <div class="consumer">
   <h1>Home page</h1>
   <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. </p>
  </div>
</template>

<script>
// @ is an alias to /src
//import * as d3 from 'd3';
import { Consumer } from 'node-rdkafka';

export default {
  name: 'Consumer',
  data() {
    return {
      data: []
    };
  },
  mounted() {
    // Create a new Kafka consumer
    const consumer = new Consumer({
      'group.id': 'kafka-graph-consumer',
      'metadata.broker.list': 'kafka-playground-kafka-bootstrap-kafka-playground.apps.devops.edubois-cloud.org:443'
    });

    // Connect the consumer to the Kafka cluster
    consumer.connect();
    /*
    // Subscribe to the specified Kafka topic
    consumer.subscribe(['data-topic']);

    // Consume messages as they arrive
    consumer.on('data', message => {
      // Parse the message to extract the data
      const data = JSON.parse(message.value.toString());

      // Update the graph with the new data
      d3.select(this.$el)
        .selectAll('circle')
        .data(data)
        .enter()
        .append('circle')
        .attr('cx', d => d.x)
        .attr('cy', d => d.y)
        .attr('r', 5);
    });*/
  }
};
</script>
